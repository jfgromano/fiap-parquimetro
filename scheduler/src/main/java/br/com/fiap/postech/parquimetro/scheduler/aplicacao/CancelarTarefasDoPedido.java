package br.com.fiap.postech.parquimetro.scheduler.aplicacao;

import br.com.fiap.postech.parquimetro.scheduler.dominio.repositorio.TarefaAgendadaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CancelarTarefasDoPedido {
    @Autowired
    TarefaAgendadaRepository repository;

    @Transactional
    public void executa(UUID idPedido) {
        repository.cancelarTarefasPorPedido(idPedido);
    }
}
