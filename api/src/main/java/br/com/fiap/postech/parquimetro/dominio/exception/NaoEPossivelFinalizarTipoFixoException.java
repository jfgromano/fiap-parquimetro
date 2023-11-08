package br.com.fiap.postech.parquimetro.dominio.exception;

public class NaoEPossivelFinalizarTipoFixoException extends DominioException{
    public NaoEPossivelFinalizarTipoFixoException() {
        super("Não é possivel finalizar periodos com data fixa!");
        this.codigo = 400;
    }
}
