package br.com.fiap.postech.parquimetro.eventos.scheduler;

import java.time.LocalDateTime;
import java.util.UUID;

public record AgendamentoTarefa(
        UUID idPedido,
        String nomeFila,
        String mensagem,
        int intervaloDeRecorrenciaEmMinutos,
        LocalDateTime dataAgendada

) {
}
