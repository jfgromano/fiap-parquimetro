package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.repositorio.EnderecoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepositoryPostgresql extends JpaRepository<Endereco, UUID>, EnderecoRepository {

    public default Endereco criaOuAtualiza(Endereco endereco) {
        return save(endereco);
    }

    public default Optional<Endereco> buscaPorId(UUID id) {
        return findById(id);
    }

    public default Optional<Endereco> buscaPorIdUsuario(UUID id) {
        Endereco endereco = new Endereco();
        Usuario usuario = new Usuario();
        usuario.setId(id);
        endereco.setUsuario(usuario);
        return findOne(Example.of(endereco));
    }
}
