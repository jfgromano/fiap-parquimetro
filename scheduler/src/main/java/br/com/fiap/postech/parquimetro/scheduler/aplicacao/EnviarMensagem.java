package br.com.fiap.postech.parquimetro.scheduler.aplicacao;

import br.com.fiap.postech.parquimetro.scheduler.dominio.TarefaAgendada;
import br.com.fiap.postech.parquimetro.scheduler.eventos.DispararEventoTarefa;
import br.com.fiap.postech.parquimetro.scheduler.dominio.repositorio.TarefaAgendadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnviarMensagem {
    @Autowired
    TarefaAgendadaRepository repository;

    @Autowired
    DispararEventoTarefa dispararEventoTarefa;

    @Transactional
    public void executa(TarefaAgendada tarefa) {
        if(tarefa.getIntervaloDeRecorrenciaEmMinutos() > 0) {
            TarefaAgendada novaTarefa = new TarefaAgendada();
            novaTarefa.setIntervaloDeRecorrenciaEmMinutos(tarefa.getIntervaloDeRecorrenciaEmMinutos());
            novaTarefa.setMensagem(tarefa.getMensagem());
            novaTarefa.setIdPedido(tarefa.getIdPedido());
            novaTarefa.setDataAgendada(LocalDateTime.now().plusMinutes(novaTarefa.getIntervaloDeRecorrenciaEmMinutos()));
            novaTarefa.setDataDoEnvio(null);
            novaTarefa.setNomeFila(tarefa.getNomeFila());
            repository.criaAtualiza(novaTarefa);
        }
        tarefa.setDataDoEnvio(LocalDateTime.now());
        repository.criaAtualiza(tarefa);
        dispararEventoTarefa.executa(tarefa.getMensagem(), tarefa.getNomeFila());
    }
}
