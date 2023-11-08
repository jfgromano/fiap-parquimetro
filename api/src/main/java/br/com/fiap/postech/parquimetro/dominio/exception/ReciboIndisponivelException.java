package br.com.fiap.postech.parquimetro.dominio.exception;

public class ReciboIndisponivelException extends DominioException{
    public ReciboIndisponivelException() {
        super("Não é possivel emitir um recibo em um periodo nao finalizado!");
        this.codigo = 400;
    }
}