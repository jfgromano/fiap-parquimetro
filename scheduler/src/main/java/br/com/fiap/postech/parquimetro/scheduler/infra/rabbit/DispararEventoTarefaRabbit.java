package br.com.fiap.postech.parquimetro.scheduler.infra.rabbit;

import br.com.fiap.postech.parquimetro.scheduler.eventos.DispararEventoTarefa;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispararEventoTarefaRabbit implements DispararEventoTarefa {

    @Autowired
    RabbitTemplate template;

    @Override
    public void executa(String mensagem, String fila) {
        template.send(fila, MessageBuilder.withBody(mensagem.getBytes()).build());
    }
}
