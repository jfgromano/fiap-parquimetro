package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;
import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.repositorio.ContatoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.EnderecoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContatoRepositoryPostgresql extends JpaRepository<Contato, UUID>, ContatoRepository {

    public default Contato criaOuAtualiza(Contato contato) {
        return save(contato);
    }

    public default Optional<Contato> buscaPorId(UUID id) {
        return findById(id);
    }

    public default Optional<Contato> buscaPorIdUsuario(UUID id) {
        Contato contato = new Contato();
        Usuario usuario = new Usuario();
        usuario.setId(id);
        contato.setUsuario(usuario);
        return findOne(Example.of(contato));
    }
}
