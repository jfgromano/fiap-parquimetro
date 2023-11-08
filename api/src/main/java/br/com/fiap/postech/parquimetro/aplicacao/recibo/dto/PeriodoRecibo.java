package br.com.fiap.postech.parquimetro.aplicacao.recibo.dto;

import br.com.fiap.postech.parquimetro.dominio.entidade.Periodo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record PeriodoRecibo(
        String tempoEstacionado,
        String inicio,
        String fim
) {
    public PeriodoRecibo(Periodo periodo) {
        this(
                periodo.getTempoEstacionado(),
                periodo.getInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                periodo.getFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
        );
    }
}
