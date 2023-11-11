package br.com.fiap.postech.parquimetro.web.validacoes;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = EnumValidador.class)
public @interface EnumValida {
    Class<? extends Enum<?>> enumClass();
    String message() default "Valor inválido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}