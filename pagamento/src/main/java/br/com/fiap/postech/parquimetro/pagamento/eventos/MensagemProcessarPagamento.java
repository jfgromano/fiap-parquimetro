package br.com.fiap.postech.parquimetro.pagamento.eventos;

import br.com.fiap.postech.parquimetro.pagamento.dominio.valueobjects.TipoPagamento;

import java.math.BigDecimal;
import java.util.UUID;

public record MensagemProcessarPagamento(
        UUID idPedido,
        String tipoPeriodo,
        int horas,
        TipoPagamento tipoPagamento,
        BigDecimal valor,
        String tokenCartao,
        boolean recorrente
) {
}
