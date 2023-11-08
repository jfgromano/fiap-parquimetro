package br.com.fiap.postech.parquimetro.web.view;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;

import java.util.UUID;

public record CartaoView(
        UUID id,
        String ultimosQuatroDigitos,
        String tipo,
        boolean principal
){
    public CartaoView(Cartao c) {
        this(
                c.getId(),
                c.getUltimosQuatroDigitos(),
                c.getTipo().getTipo(),
                c.isPrincipal()
        );
    }
}