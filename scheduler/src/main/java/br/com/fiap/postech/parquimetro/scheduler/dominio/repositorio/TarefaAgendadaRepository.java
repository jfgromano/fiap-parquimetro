package br.com.fiap.postech.parquimetro.scheduler.dominio.repositorio;

import br.com.fiap.postech.parquimetro.scheduler.dominio.TarefaAgendada;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TarefaAgendadaRepository {
    TarefaAgendada criaAtualiza(TarefaAgendada tarefaAgendada);
    void cancelarTarefasPorPedido(UUID idPedido);
    List<TarefaAgendada> buscarTarefasPendentes(LocalDateTime now);
}
