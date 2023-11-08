package br.com.fiap.postech.parquimetro.notificacoes.infra.jackson;

public class JsonConverterException extends RuntimeException{
    public JsonConverterException(String message, Exception e) {
        super(message, e);
    }
}
