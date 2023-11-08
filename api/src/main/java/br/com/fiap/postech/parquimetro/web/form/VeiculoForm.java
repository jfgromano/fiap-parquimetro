package br.com.fiap.postech.parquimetro.web.form;

import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VeiculoForm(
        @Pattern(regexp = "^[a-zA-Z]{3}[0-9][A-Za-z0-9][0-9]{2}$", message = "deve ser uma placa valida")
        @NotBlank
        String placa,
        @NotBlank
        String cor,
        @NotBlank
        String marca,
        @NotBlank
        String modelo) {
    public Veiculo asVeiculo() {
        Veiculo veiculo = new Veiculo(
                this.placa,
                this.cor,
                this.marca,
                this.modelo
        );
        return veiculo;
    }
}