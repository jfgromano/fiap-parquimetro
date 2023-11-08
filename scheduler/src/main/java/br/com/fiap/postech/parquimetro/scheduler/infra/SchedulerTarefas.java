package br.com.fiap.postech.parquimetro.scheduler.infra;

import br.com.fiap.postech.parquimetro.scheduler.aplicacao.EnviarTarefasAgendadasPendentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTarefas {
    @Autowired
    EnviarTarefasAgendadasPendentes enviarTarefasAgendadasPendentes;
    @Scheduled(fixedRate = 1000L)
    public void executar() {
        enviarTarefasAgendadasPendentes.executa();
    }
}
