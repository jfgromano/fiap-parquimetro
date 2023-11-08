package br.com.fiap.postech.parquimetro.infra.rabbit;

import br.com.fiap.postech.parquimetro.dominio.JsonConverter;
import br.com.fiap.postech.parquimetro.eventos.scheduler.DispararEventoAgendarTarefas;
import br.com.fiap.postech.parquimetro.eventos.scheduler.AgendamentoTarefa;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispararEventoAgendarTarefasRabbit implements DispararEventoAgendarTarefas {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private JsonConverter jsonConverter;

    @Override
    public void enviar(AgendamentoTarefa event) {
        String json = jsonConverter.toJson(event);
        rabbitTemplate.send(Filas.OUT_AGENDAR_TAREFAS, MessageBuilder.withBody(json.getBytes()).build());
    }
}
