package br.com.fiap.postech.parquimetro.infra.rabbit;

import br.com.fiap.postech.parquimetro.dominio.JsonConverter;
import br.com.fiap.postech.parquimetro.eventos.processarpagamento.DispararEventoProcessarPagamento;
import br.com.fiap.postech.parquimetro.eventos.processarpagamento.ProcessarPagamento;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispararEventoProcessarPagamentoRabbit implements DispararEventoProcessarPagamento {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private JsonConverter jsonConverter;


    @Override
    public void enviar(ProcessarPagamento conteudo) {
        String json = jsonConverter.toJson(conteudo);
        rabbitTemplate.send(Filas.OUT_PROCESSAR_PAGAMENTO, MessageBuilder.withBody(json.getBytes()).build());
    }
}
