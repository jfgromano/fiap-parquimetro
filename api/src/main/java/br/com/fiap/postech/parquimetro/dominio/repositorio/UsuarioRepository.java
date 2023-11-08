package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    public Usuario cria(Usuario usuario);
    public Optional<Usuario> buscaPorEmailSenha(String nome, String email);
    public Optional<Usuario> buscaPorEmail(String email);
}