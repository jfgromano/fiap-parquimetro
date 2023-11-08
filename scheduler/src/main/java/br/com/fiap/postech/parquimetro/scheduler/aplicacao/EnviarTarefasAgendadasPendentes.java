package br.com.fiap.postech.parquimetro.scheduler.aplicacao;

import br.com.fiap.postech.parquimetro.scheduler.dominio.TarefaAgendada;
import br.com.fiap.postech.parquimetro.scheduler.dominio.repositorio.TarefaAgendadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class EnviarTarefasAgendadasPendentes {
    @Autowired
    TarefaAgendadaRepository repository;

    @Autowired
    EnviarMensagem enviarMensagem;

    public void executa() {
        List<TarefaAgendada> tarefas = repository.buscarTarefasPendentes( LocalDateTime.now());
        for (TarefaAgendada tarefa: tarefas) {
            enviarMensagem.executa(tarefa);
        }
    }
}
