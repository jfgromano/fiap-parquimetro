package br.com.fiap.postech.parquimetro.aplicacao.recibo.dto;

import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;

import java.util.UUID;

public record VeiculoRecibo(
        UUID id,
        String placa,
        String cor,
        String marca,
        String modelo
){
    public VeiculoRecibo(Veiculo v) {
        this(
                v.getId(),
                v.getPlaca(),
                v.getCor(),
                v.getMarca(),
                v.getModelo()
        );
    }
}