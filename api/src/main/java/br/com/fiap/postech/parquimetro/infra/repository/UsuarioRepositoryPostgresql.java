package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.repositorio.UsuarioRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepositoryPostgresql extends JpaRepository<Usuario, UUID>, UsuarioRepository {

    public default Usuario cria(Usuario usuario) {
        return save(usuario);
    }

    public default Optional<Usuario> buscaPorEmailSenha(String email, String senha) {
        return findOne(Example.of(new Usuario(email, senha)));
    }

    public default Optional<Usuario> buscaPorEmail(String email) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        return findOne(Example.of(usuario));
    }
}
