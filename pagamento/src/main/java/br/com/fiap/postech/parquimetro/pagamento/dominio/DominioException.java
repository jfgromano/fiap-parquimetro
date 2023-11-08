package br.com.fiap.postech.parquimetro.pagamento.dominio;

public class DominioException extends RuntimeException{
    protected int codigo = 500;

    public DominioException(String s) {
        super(s);
    }

    public int getCodigo() {
        return codigo;
    }
}
