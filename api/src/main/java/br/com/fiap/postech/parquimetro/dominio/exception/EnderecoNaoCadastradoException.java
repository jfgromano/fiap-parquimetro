package br.com.fiap.postech.parquimetro.dominio.exception;

public class EnderecoNaoCadastradoException extends DominioException{
    public EnderecoNaoCadastradoException() {
        super("Nao foi possivel localizar o endereço!");
        this.codigo = 404;
    }
}
