package br.com.fiap.postech.parquimetro.scheduler.eventos;

public interface ListenerAgendamento {
    public void apply(AgendamentoTarefaEvent event);
}
