package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CartaoRepository {
    public Cartao criaOuAtualiza(Cartao cartao);
    public Optional<Cartao> buscaPorId(UUID id);
    public List<Cartao> buscaPorIdUsuario(UUID idUsuario);
    public void remover(Cartao cartao);
    public void removerFlagCartaoPrincipal(UUID idUsuario);
}