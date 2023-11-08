package br.com.fiap.postech.parquimetro.eventos.processarpagamento;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.TipoPagamento;

import java.math.BigDecimal;
import java.util.UUID;

public record ProcessarPagamento(
        UUID idPedido,
        String tipoPeriodo,
        int horas,
        String tipoPagamento,
        BigDecimal valor,
        String tokenCartao
) {
    public ProcessarPagamento(Pedido pedido, TipoPagamento tipoPagamento, String tokenCartao) {
        this(pedido.getId(), pedido.getTipoPeriodo().getNome(), pedido.getHoras(), tipoPagamento.name(), pedido.calcularValor(), tokenCartao);
    }
}
