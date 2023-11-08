package br.com.fiap.postech.parquimetro.dominio.exception;

public class ParametroInvalidoException extends DominioException{
    public ParametroInvalidoException(String msg) {
        super(msg);
        this.codigo = 400;
    }
}
