package br.com.fiap.postech.parquimetro.dominio.exception;

public class PeriodoEstacionamentoNaoCadastradoException extends DominioException{
    public PeriodoEstacionamentoNaoCadastradoException() {
        super("Nao foi possivel localizar o periodo de estacionamento!");
        this.codigo = 404;
    }
}
