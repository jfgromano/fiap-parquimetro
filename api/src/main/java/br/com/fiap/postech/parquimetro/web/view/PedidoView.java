package br.com.fiap.postech.parquimetro.web.view;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;

import java.util.UUID;

public record PedidoView(
        UUID id,
        String tipoPeriodo,
        int horas,
        String statusPagamento
){
    public PedidoView(Pedido pedido) {
        this(
                pedido.getId(),
                pedido.getTipoPeriodo().getNome(),
                pedido.getHoras(),
                pedido.getStatusPagamento().name()
        );
    }
}