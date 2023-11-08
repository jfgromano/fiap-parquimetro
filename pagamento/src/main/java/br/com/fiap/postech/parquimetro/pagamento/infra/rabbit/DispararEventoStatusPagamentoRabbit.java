package br.com.fiap.postech.parquimetro.pagamento.infra.rabbit;

import br.com.fiap.postech.parquimetro.pagamento.eventos.DispararEventoStatusPagamento;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispararEventoStatusPagamentoRabbit implements DispararEventoStatusPagamento {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void enviar(String conteudo) {
        rabbitTemplate.send(Filas.OUT_ATUALIZAR_STATUS_PAGAMENTO, MessageBuilder.withBody(conteudo.getBytes()).build());
    }
}
