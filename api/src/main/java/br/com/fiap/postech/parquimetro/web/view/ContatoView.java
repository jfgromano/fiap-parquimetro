package br.com.fiap.postech.parquimetro.web.view;

import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;

import java.util.UUID;

public record ContatoView(
        UUID id,
        String email,
        String numeroCelular
){
    public ContatoView(Contato c) {
        this(
                c.getId(),
                c.getEmail(),
                c.getNumeroCelular()
        );
    }
}
