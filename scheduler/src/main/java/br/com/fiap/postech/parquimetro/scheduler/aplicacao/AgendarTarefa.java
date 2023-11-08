package br.com.fiap.postech.parquimetro.scheduler.aplicacao;

import br.com.fiap.postech.parquimetro.scheduler.dominio.TarefaAgendada;
import br.com.fiap.postech.parquimetro.scheduler.eventos.AgendamentoTarefaEvent;
import br.com.fiap.postech.parquimetro.scheduler.dominio.repositorio.TarefaAgendadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarTarefa {
    @Autowired
    TarefaAgendadaRepository repository;

    public void executa(AgendamentoTarefaEvent event) {
        TarefaAgendada tarefa = new TarefaAgendada();
        tarefa.setIdPedido(event.idPedido());
        tarefa.setNomeFila(event.nomeFila());
        tarefa.setMensagem(event.mensagem());
        tarefa.setDataAgendada(event.dataAgendada());
        tarefa.setIntervaloDeRecorrenciaEmMinutos(event.intervaloDeRecorrenciaEmMinutos());
        repository.criaAtualiza(tarefa);
    }
}
