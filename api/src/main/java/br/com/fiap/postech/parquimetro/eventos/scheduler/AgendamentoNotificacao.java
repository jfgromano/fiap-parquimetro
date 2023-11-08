package br.com.fiap.postech.parquimetro.eventos.scheduler;

import java.util.UUID;

public record AgendamentoNotificacao(
        String conteudo,
        UUID idPedido
) {
}
