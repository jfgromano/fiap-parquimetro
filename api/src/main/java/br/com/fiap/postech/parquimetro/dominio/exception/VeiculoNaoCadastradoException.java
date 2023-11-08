package br.com.fiap.postech.parquimetro.dominio.exception;

public class VeiculoNaoCadastradoException extends DominioException{
    public VeiculoNaoCadastradoException() {
        super("Nao foi possivel localizar o veiculo!");
        this.codigo = 404;
    }
}
