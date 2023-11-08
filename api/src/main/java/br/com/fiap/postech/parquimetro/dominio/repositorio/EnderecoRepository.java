package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnderecoRepository {
    public Endereco criaOuAtualiza(Endereco endereco);
    public Optional<Endereco> buscaPorId(UUID id);
    public Optional<Endereco> buscaPorIdUsuario(UUID idUsuario);
}
