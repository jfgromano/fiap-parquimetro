package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;

import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {
    public Pedido criaAtualiza(Pedido pedido);
    public Optional<Pedido> buscaPorId(UUID id);
}
