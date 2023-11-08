package br.com.fiap.postech.parquimetro.scheduler.eventos;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoTarefaEvent(
        UUID idPedido,
        String nomeFila,
        String mensagem,
        int intervaloDeRecorrenciaEmMinutos,
        LocalDateTime dataAgendada

) {
}
