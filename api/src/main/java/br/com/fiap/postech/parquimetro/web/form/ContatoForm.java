package br.com.fiap.postech.parquimetro.web.form;

import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;
import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.Estado;
import br.com.fiap.postech.parquimetro.web.validacoes.EstadoEnderecoValido;
import br.com.fiap.postech.parquimetro.web.validacoes.NullOrNotBlank;
import br.com.fiap.postech.parquimetro.web.validacoes.Number;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ContatoForm(
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "^\\([1-9]{2}\\) [9]{1}[0-9]{4}-[0-9]{4}$", message = "deve ser um numero de celular no formato (xx) 9xxxx-xxxx")
        String numeroCelular) {
    public Contato asContato() {
        Contato contato = new Contato(
                this.email,
                this.numeroCelular
        );
        return contato;
    }
}