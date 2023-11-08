package br.com.fiap.postech.parquimetro.scheduler.infra.repositorio;

import br.com.fiap.postech.parquimetro.scheduler.dominio.TarefaAgendada;
import br.com.fiap.postech.parquimetro.scheduler.dominio.repositorio.TarefaAgendadaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface TarefaAgendadaRepositoryPostgresql extends JpaRepository<TarefaAgendada, UUID>,  TarefaAgendadaRepository {
    default TarefaAgendada criaAtualiza(TarefaAgendada tarefaAgendada) {
        return this.save(tarefaAgendada);
    }

    @Modifying
    @Query("update TarefaAgendada t set t.cancelada = true WHERE t.idPedido = :id")
    void cancelarTarefasPorPedido(@Param(value = "id") UUID idPedido);

    @Query(value = "SELECT t FROM TarefaAgendada t WHERE t.cancelada = false AND t.dataDoEnvio IS NULL AND t.dataAgendada <= :dataAtual ORDER BY t.dataAgendada ASC")
    List<TarefaAgendada> buscarTarefasPendentes(@Param(value = "dataAtual") LocalDateTime now);
}
