package br.com.fiap.postech.parquimetro.scheduler.eventos;

import java.util.UUID;

public record CancelamentoTarefaEvent(
        UUID idPedido

) {
}
