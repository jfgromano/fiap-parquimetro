package br.com.fiap.postech.parquimetro.aplicacao.periodo;

import br.com.fiap.postech.parquimetro.dominio.JsonConverter;
import br.com.fiap.postech.parquimetro.dominio.MensagemNotificacaoBuilder;
import br.com.fiap.postech.parquimetro.eventos.scheduler.DispararEventoAgendarTarefas;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.Periodo;
import br.com.fiap.postech.parquimetro.eventos.scheduler.AgendamentoTarefa;
import br.com.fiap.postech.parquimetro.eventos.scheduler.AgendamentoNotificacao;
import br.com.fiap.postech.parquimetro.eventos.scheduler.AgendamentoPagamentoRecorrente;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PeriodoRepository;
import br.com.fiap.postech.parquimetro.infra.rabbit.Filas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class IniciarPeriodoEstacionamento {
    @Autowired
    PeriodoRepository periodoRepository;

    @Autowired
    DispararEventoAgendarTarefas dispararEventoAgendarTarefas;

    @Autowired
    JsonConverter jsonConverter;

    public Periodo executa(Pedido pedido, UUID idPagamento) {
        Periodo periodo = new Periodo();
        periodo.setFinalizado(false);
        periodo.setUsuario(pedido.getUsuario());
        periodo.setInicio(LocalDateTime.now());
        periodo.setPedido(pedido);
        if(pedido.getTipoPeriodo().fixo()) {
            LocalDateTime periodoFim = periodo.getInicio().plusHours(pedido.getHoras());
            periodo.setFim(periodoFim);
        }

        periodoRepository.criaAtualiza(periodo);
        AgendamentoTarefa eventoNotificacao = criarEventoNofificacao(pedido, periodo);
        dispararEventoAgendarTarefas.enviar(eventoNotificacao);
        if(!pedido.getTipoPeriodo().fixo()) {
            AgendamentoTarefa eventoPagamentoRecorrente = criarEventoPagamentoRecorrente(pedido, periodo, idPagamento);
            dispararEventoAgendarTarefas.enviar(eventoPagamentoRecorrente);
        }

        return periodo;
    }

    private AgendamentoTarefa criarEventoNofificacao(Pedido pedido, Periodo periodo) {
        LocalDateTime dataAgendamentoNotificacao;
        int intervaloRecorrenciaNotificacao = 60;
        if(pedido.getTipoPeriodo().fixo()) {
            intervaloRecorrenciaNotificacao = 0;
            dataAgendamentoNotificacao = periodo.getFim().minusMinutes(10);
        }else {
            dataAgendamentoNotificacao = periodo.getInicio().plusMinutes(50);
        }

        AgendamentoNotificacao msg = new MensagemNotificacaoBuilder(jsonConverter).comPedidoEPeriodo(pedido, periodo);
        return new AgendamentoTarefa(
                pedido.getId(),
                Filas.OUT_NOTIFICACOES,
                jsonConverter.toJson(msg),
                intervaloRecorrenciaNotificacao,
                dataAgendamentoNotificacao
        );
    }

    private AgendamentoTarefa criarEventoPagamentoRecorrente(Pedido pedido, Periodo periodo, UUID pagamentoId) {
        int intervaloRecorrencia = 60;
        LocalDateTime dataFim = periodo.getInicio().plusMinutes(intervaloRecorrencia);
        AgendamentoPagamentoRecorrente msg = new AgendamentoPagamentoRecorrente(pedido.getId(), pagamentoId);
        return new AgendamentoTarefa(
                pedido.getId(),
                Filas.OUT_PROCESSAR_PAGAMENTO_RECORRENTE,
                jsonConverter.toJson(msg),
                intervaloRecorrencia,
                dataFim
        );
    }
}
