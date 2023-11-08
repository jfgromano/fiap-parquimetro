package br.com.fiap.postech.parquimetro.pagamento.eventos;

import br.com.fiap.postech.parquimetro.pagamento.dominio.valueobjects.TipoPagamento;

import java.math.BigDecimal;
import java.util.UUID;

public record MensagemPagamentoRecorrente(
        UUID idPedido,
        UUID idPagamentoBase
) {
}
