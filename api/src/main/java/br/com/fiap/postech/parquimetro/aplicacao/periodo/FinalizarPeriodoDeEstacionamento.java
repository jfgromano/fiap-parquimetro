package br.com.fiap.postech.parquimetro.aplicacao.periodo;

import br.com.fiap.postech.parquimetro.aplicacao.pedido.BuscarPedidoPorId;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.Periodo;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.eventos.scheduler.CancelarAgendamentos;
import br.com.fiap.postech.parquimetro.eventos.scheduler.DispararEventoCancelarAgendamentosDoPedido;
import br.com.fiap.postech.parquimetro.dominio.exception.PeriodoEstacionamentoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.exception.PeriodoJaFinalizadoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class FinalizarPeriodoDeEstacionamento {
    @Autowired
    BuscarPedidoPorId buscarPedido;
    @Autowired
    PeriodoRepository periodoRepository;

    @Autowired
    private TransactionTemplate template;

    @Autowired
    private DispararEventoCancelarAgendamentosDoPedido dispararEventoCancelarAgendamentosDoPedido;

    @Autowired
    BuscarPeriodoDoPedido buscarPeriodoDoPedido;

    public Pedido executa(UUID idPedido, Usuario usuario) {
        Pedido pedido = buscarPedido.executa(usuario, idPedido);
        Periodo periodo = buscarPeriodoDoPedido.executa(pedido);

        if(periodo.isFinalizado()) {
            throw new PeriodoJaFinalizadoException();
        }

        template.execute(s ->  {
            if(pedido.getTipoPeriodo().fixo() == false) {
                periodo.setFim(LocalDateTime.now());
            }
            periodo.finaliza();
            periodoRepository.criaAtualiza(periodo);
            CancelarAgendamentos event = new CancelarAgendamentos(idPedido);
            dispararEventoCancelarAgendamentosDoPedido.enviar(event);
            return null;
        });

        return pedido;
    }
}
