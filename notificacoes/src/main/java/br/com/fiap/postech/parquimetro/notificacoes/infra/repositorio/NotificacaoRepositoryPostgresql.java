package br.com.fiap.postech.parquimetro.notificacoes.infra.repositorio;

import br.com.fiap.postech.parquimetro.notificacoes.dominio.Notificacao;
import br.com.fiap.postech.parquimetro.notificacoes.dominio.NotificacaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificacaoRepositoryPostgresql extends JpaRepository<Notificacao, UUID>, NotificacaoRepository {
    default Notificacao criaAtualiza(Notificacao notificacao) {
        return this.save(notificacao);
    }
}
