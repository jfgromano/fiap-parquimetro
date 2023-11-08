package br.com.fiap.postech.parquimetro.infra.jackson;

import br.com.fiap.postech.parquimetro.dominio.JsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonConverterJackson implements JsonConverter {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String toJson(Object object) {
        try {
            return this.objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new JsonConverterException("Error writing to JSON", e);
        }
    }
}
