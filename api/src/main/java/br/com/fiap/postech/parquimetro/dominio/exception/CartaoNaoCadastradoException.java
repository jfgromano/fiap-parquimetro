package br.com.fiap.postech.parquimetro.dominio.exception;

public class CartaoNaoCadastradoException extends DominioException{
    public CartaoNaoCadastradoException() {
        super("Nao foi possivel localizar o cartão!");
        this.codigo = 404;
    }
}
