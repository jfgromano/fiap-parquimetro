package br.com.fiap.postech.parquimetro.eventos.processarpagamento;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.StatusPagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    public Pagamento asPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(id);
        pagamento.setTipo(tipoPagamento);
        pagamento.setValor(valor);
        return pagamento;
    }
}
