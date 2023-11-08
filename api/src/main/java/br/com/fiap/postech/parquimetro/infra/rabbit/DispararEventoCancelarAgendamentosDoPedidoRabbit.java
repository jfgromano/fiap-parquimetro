package br.com.fiap.postech.parquimetro.infra.rabbit;

import br.com.fiap.postech.parquimetro.dominio.JsonConverter;
import br.com.fiap.postech.parquimetro.eventos.scheduler.CancelarAgendamentos;
import br.com.fiap.postech.parquimetro.eventos.scheduler.DispararEventoCancelarAgendamentosDoPedido;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispararEventoCancelarAgendamentosDoPedidoRabbit implements DispararEventoCancelarAgendamentosDoPedido {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    JsonConverter converter;

    @Override
    public void enviar(CancelarAgendamentos cancelarAgendamentos) {
        String json = converter.toJson(cancelarAgendamentos);
        rabbitTemplate.send(Filas.OUT_CANCELAR_TAREFAS_AGENDADAS, MessageBuilder.withBody(json.getBytes()).build());
    }
}
