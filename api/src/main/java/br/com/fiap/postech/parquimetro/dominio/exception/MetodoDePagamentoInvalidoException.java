package br.com.fiap.postech.parquimetro.dominio.exception;

public class MetodoDePagamentoInvalidoException extends DominioException{
    public MetodoDePagamentoInvalidoException() {
        super("O metodo de pagamento é invalido!");
        this.codigo = 400;
    }
}