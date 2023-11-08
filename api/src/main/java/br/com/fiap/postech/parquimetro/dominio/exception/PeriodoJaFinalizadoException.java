package br.com.fiap.postech.parquimetro.dominio.exception;

public class PeriodoJaFinalizadoException extends DominioException {
    public PeriodoJaFinalizadoException() {
        super("O periodo ja foi finalizado!");
        this.codigo = 400;
    }
}