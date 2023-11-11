package br.com.fiap.postech.parquimetro.dominio.exception;

public class DominioException extends RuntimeException{
    protected int codigo = 500;

    public DominioException(String s) {
        super(s);
    }

    public int getCodigo() {
        return codigo;
    }
}
