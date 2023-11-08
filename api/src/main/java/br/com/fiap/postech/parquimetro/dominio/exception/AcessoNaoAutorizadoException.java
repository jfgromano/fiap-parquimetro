package br.com.fiap.postech.parquimetro.dominio.exception;

public class AcessoNaoAutorizadoException extends DominioException {
    public AcessoNaoAutorizadoException() {
        super("Você não esta autorizado a executar esta ação!");
        this.codigo = 403;
    }
}
