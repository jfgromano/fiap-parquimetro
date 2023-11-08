package br.com.fiap.postech.parquimetro.scheduler.eventos;

public interface ListenerCancelamento {
    public void apply(CancelamentoTarefaEvent cancelamentoTarefaEvent);
}
