package br.com.fiap.postech.parquimetro.pagamento.eventos;

import br.com.fiap.postech.parquimetro.pagamento.dominio.Pagamento;
import br.com.fiap.postech.parquimetro.pagamento.dominio.valueobjects.StatusPagamento;
import br.com.fiap.postech.parquimetro.pagamento.dominio.valueobjects.TipoPagamento;

import java.math.BigDecimal;
import java.util.UUID;

public record StatusPagamentoProcessado(
        UUID id,
        String CartaoToken,
        TipoPagamento tipoPagamento,
        BigDecimal valor,
        StatusPagamento status,
        String dadosPagamento,
        UUID pedidoId,
        boolean recorrente
) {
    public StatusPagamentoProcessado(Pagamento pagamento) {
        this(
                pagamento.getId(),
                pagamento.getCartaoToken(),
                pagamento.getTipoPagamento(),
                pagamento.getValor(),
                StatusPagamento.valueOf(pagamento.getStatus()),
                pagamento.getDadosPagamento(),
                pagamento.getPedidoId(),
                pagamento.isRecorrente()
        );
    }
}
