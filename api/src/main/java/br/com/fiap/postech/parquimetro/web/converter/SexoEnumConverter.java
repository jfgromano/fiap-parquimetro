package br.com.fiap.postech.parquimetro.web.converter;

import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.Sexo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SexoEnumConverter implements Converter<String, Sexo> {
    @Override
    public Sexo convert(String value) {
        try {
            return Sexo.valueOf(value.toUpperCase());
        }catch (Exception e){};
        return Sexo.buscarPorSigla(value);
    }
}