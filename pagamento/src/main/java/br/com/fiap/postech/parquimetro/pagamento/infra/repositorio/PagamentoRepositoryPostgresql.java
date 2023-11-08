package br.com.fiap.postech.parquimetro.pagamento.infra.repositorio;

import br.com.fiap.postech.parquimetro.pagamento.dominio.Pagamento;
import br.com.fiap.postech.parquimetro.pagamento.dominio.PagamentoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PagamentoRepositoryPostgresql extends JpaRepository<Pagamento, UUID>, PagamentoRepository {
    public default Pagamento criaAtualiza(Pagamento pagamento) {
        return this.save(pagamento);
    }

    public default Optional<Pagamento> buscaPorId(UUID id) {
        return findById(id);
    }
}
