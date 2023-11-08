package br.com.fiap.postech.parquimetro.dominio.exception;

public class ContatoNaoCadastradoException extends DominioException{
    public ContatoNaoCadastradoException() {
        super("Nao foi possivel localizar o contato!");
        this.codigo = 404;
    }
}
