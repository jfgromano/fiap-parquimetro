package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;

import java.util.Optional;
import java.util.UUID;

public interface PagamentoRepository {
    public Pagamento criaAtualiza(Pagamento pagamento);
}
