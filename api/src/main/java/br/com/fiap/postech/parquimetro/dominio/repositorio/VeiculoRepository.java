package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VeiculoRepository {
    public Veiculo criaOuAtualiza(Veiculo veiculo);
    public Optional<Veiculo> buscaPorId(UUID id);
    public List<Veiculo> buscaPorIdUsuario(UUID idUsuario);
    public void remover(Veiculo veiculo);
}
