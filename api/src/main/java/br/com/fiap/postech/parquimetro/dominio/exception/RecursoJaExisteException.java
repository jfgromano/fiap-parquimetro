package br.com.fiap.postech.parquimetro.dominio.exception;

public class RecursoJaExisteException extends DominioException{
    public RecursoJaExisteException(String msg) {
        super(msg);
        this.codigo = 409;
    }
}
