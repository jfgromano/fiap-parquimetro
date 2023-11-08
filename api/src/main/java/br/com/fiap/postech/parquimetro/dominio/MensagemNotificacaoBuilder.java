package br.com.fiap.postech.parquimetro.dominio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.Periodo;
import br.com.fiap.postech.parquimetro.eventos.scheduler.AgendamentoNotificacao;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class MensagemNotificacaoBuilder {
    JsonConverter converter;

    public MensagemNotificacaoBuilder(JsonConverter jsonConverter) {
        this.converter = jsonConverter;
    }

    public AgendamentoNotificacao comPedidoEPeriodo(Pedido pedido, Periodo periodo) {
        Map<String, Object> dados = new HashMap<>();
        dados.put("assunto", "Periodo estacionamento");
        dados.put("email", pedido.getUsuario().getContato().getEmail());
        String corpo = Notificacoes.PERIODO_FIXO_EXPIRANDO.getMensagem();
        if(!pedido.getTipoPeriodo().fixo()) {
            corpo = Notificacoes.PERIODO_VARIAVEL_EXPIRANDO.getMensagem();
        }

        dados.put("corpo", corpo);
        ObjectMapper objectMapper = new ObjectMapper();
        String conteudo = converter.toJson(dados);

        return new AgendamentoNotificacao(
                conteudo,
                pedido.getId()
        );

    }
}
