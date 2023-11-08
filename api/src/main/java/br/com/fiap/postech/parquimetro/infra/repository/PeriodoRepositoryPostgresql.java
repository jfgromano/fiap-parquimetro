package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.Periodo;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PedidoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PeriodoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PeriodoRepositoryPostgresql extends JpaRepository<Periodo, UUID>, PeriodoRepository {
    public default Periodo criaAtualiza(Periodo periodo) {
        return this.save(periodo);
    }
    public default Optional<Periodo> buscaPorIdPedido(UUID id) {
        Pedido pedido = new Pedido();
        pedido.setId(id);
        Periodo periodo = new Periodo();
        periodo.setPedido(pedido);
        return findOne(Example.of(periodo));
    }
}
