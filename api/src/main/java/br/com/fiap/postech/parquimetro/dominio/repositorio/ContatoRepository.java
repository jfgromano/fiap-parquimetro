package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;
import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;

import java.util.Optional;
import java.util.UUID;

public interface ContatoRepository {
    public Contato criaOuAtualiza(Contato contato);
    public Optional<Contato> buscaPorId(UUID id);
    public Optional<Contato> buscaPorIdUsuario(UUID idUsuario);
}