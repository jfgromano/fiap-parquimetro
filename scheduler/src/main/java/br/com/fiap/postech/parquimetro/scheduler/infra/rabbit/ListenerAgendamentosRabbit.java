package br.com.fiap.postech.parquimetro.scheduler.infra.rabbit;

import br.com.fiap.postech.parquimetro.scheduler.aplicacao.AgendarTarefa;
import br.com.fiap.postech.parquimetro.scheduler.eventos.ListenerAgendamento;
import br.com.fiap.postech.parquimetro.scheduler.eventos.AgendamentoTarefaEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerAgendamentosRabbit implements ListenerAgendamento {

    @Autowired
    AgendarTarefa agendarTarefa;
    @RabbitListener(queues = Filas.IN_AGENDAMENTOS)
    public void apply(AgendamentoTarefaEvent event) {
        agendarTarefa.executa(event);
    }
}
