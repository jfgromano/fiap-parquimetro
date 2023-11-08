package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.TipoPeriodo;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PedidoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.TipoPeriodoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PedidoRepositoryPostgresql extends JpaRepository<Pedido, UUID>, PedidoRepository {
    public default Pedido criaAtualiza(Pedido pedido) {
        return this.save(pedido);
    }

    public default Optional<Pedido> buscaPorId(UUID id) {
        return findById(id);
    }
}
