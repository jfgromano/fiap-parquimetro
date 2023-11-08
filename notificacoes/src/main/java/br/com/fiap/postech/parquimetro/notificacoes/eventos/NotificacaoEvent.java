package br.com.fiap.postech.parquimetro.notificacoes.eventos;

import java.util.UUID;

public record NotificacaoEvent(
        String conteudo,
        UUID idPedido
) {
}
