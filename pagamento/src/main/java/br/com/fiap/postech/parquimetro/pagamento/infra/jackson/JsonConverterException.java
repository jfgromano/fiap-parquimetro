package br.com.fiap.postech.parquimetro.pagamento.infra.jackson;

public class JsonConverterException extends RuntimeException{
    public JsonConverterException(String message, Exception e) {
        super(message, e);
    }
}
