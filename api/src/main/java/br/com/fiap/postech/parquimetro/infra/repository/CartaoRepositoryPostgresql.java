package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.repositorio.CartaoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.ContatoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartaoRepositoryPostgresql extends JpaRepository<Cartao, UUID>, CartaoRepository {

    public default Cartao criaOuAtualiza(Cartao cartao) {
        return save(cartao);
    }

    public default Optional<Cartao> buscaPorId(UUID id) {
        return findById(id);
    }

    public default List<Cartao> buscaPorIdUsuario(UUID id) {
        Cartao cartao = new Cartao();
        Usuario usuario = new Usuario();
        usuario.setId(id);
        cartao.setUsuario(usuario);
        return findAll(Example.of(cartao));
    }

    @Modifying
    @Query("update Cartao c set c.principal = false where c.usuario.id = :id and c.principal = true")
    public void removerFlagCartaoPrincipal(@Param(value = "id") UUID idUsuario);
    public default void remover(Cartao cartao) {
        delete(cartao);
    }
}
