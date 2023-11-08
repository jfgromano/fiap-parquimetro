package br.com.fiap.postech.parquimetro.aplicacao.recibo.dto;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;

import java.util.UUID;

public record CartaoRecibo(
        UUID id,
        String ultimosQuatroDigitos,
        String tipo,
        boolean principal
){
    public CartaoRecibo(Cartao c) {
        this(
                c.getId(),
                c.getUltimosQuatroDigitos(),
                c.getTipo().getTipo(),
                c.isPrincipal()
        );
    }
}