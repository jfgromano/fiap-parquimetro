package br.com.fiap.postech.parquimetro.web.view;

import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;

import java.util.UUID;

public record VeiculoView(
        UUID id,
        String placa,
        String cor,
        String marca,
        String modelo
){
    public VeiculoView(Veiculo v) {
        this(
                v.getId(),
                v.getPlaca(),
                v.getCor(),
                v.getMarca(),
                v.getModelo()
        );
    }
}