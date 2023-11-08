package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.repositorio.EnderecoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface VeiculoRepositoryPostgresql extends JpaRepository<Veiculo, UUID>, VeiculoRepository {

    public default Veiculo criaOuAtualiza(Veiculo veiculo) {
        return save(veiculo);
    }

    public default Optional<Veiculo> buscaPorId(UUID id) {
        return findById(id);
    }

    public default List<Veiculo> buscaPorIdUsuario(UUID id) {
        Veiculo veiculo = new Veiculo();
        Usuario usuario = new Usuario();
        usuario.setId(id);
        veiculo.setUsuario(usuario);
        return findAll(Example.of(veiculo));
    }

    public default void remover(Veiculo veiculo) {
        delete(veiculo);
    }
}
