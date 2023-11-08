package br.com.fiap.postech.parquimetro.web.form;

import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.Estado;
import br.com.fiap.postech.parquimetro.web.validacoes.EstadoEnderecoValido;
import br.com.fiap.postech.parquimetro.web.validacoes.NullOrNotBlank;
import br.com.fiap.postech.parquimetro.web.validacoes.Number;
import jakarta.validation.constraints.NotBlank;

public record EnderecoForm(
        @NotBlank
        String rua,
        @Number(required = false)
        String numero,
        @NullOrNotBlank
        String bairro,
        @NotBlank
        String cidade,
        @EstadoEnderecoValido
        String estado) {
    public Endereco asEndereco() {
        Endereco endereco = new Endereco(
                this.rua,
                this.numero,
                this.bairro,
                this.cidade,
                Estado.buscarPorSigla(this.estado)
        );
        return endereco;
    }
}