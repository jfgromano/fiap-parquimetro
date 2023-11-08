package br.com.fiap.postech.parquimetro.dominio.exception;

public class PedidoNaoCadastradoException extends DominioException{
    public PedidoNaoCadastradoException() {
        super("Nao foi possivel localizar o pedido!");
        this.codigo = 404;
    }
}
