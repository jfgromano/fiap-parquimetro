package br.com.fiap.postech.parquimetro.eventos.scheduler;

import java.util.UUID;

public record AgendamentoPagamentoRecorrente(
        UUID idPedido,
        UUID idPagamentoBase
) {
}
