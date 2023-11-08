package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PagamentoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PedidoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PagamentoRepositoryPostgresql extends JpaRepository<Pagamento, UUID>, PagamentoRepository {
    public default Pagamento criaAtualiza(Pagamento pagamento) {
        return this.save(pagamento);
    }
}
