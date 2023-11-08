package br.com.fiap.postech.parquimetro.web.form;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.CartaoTipo;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.Sexo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record CartaoForm(
    @NotBlank
    String ultimosQuatroDigitos,
    @NotBlank
    String token,
    @NotBlank
    @Pattern(regexp = "^(debito|credito)$", message = "debito ou credito")
    String tipo,
    @NotNull
    @Pattern(regexp = "^true$|^false$", message = "true ou false")
    String principal
) {
    public Cartao asCartao() {
        Cartao cartao = new Cartao(
                this.token,
                this.ultimosQuatroDigitos,
                CartaoTipo.buscarPorTipo(this.tipo),
                this.principal.equals("true")
        );
        return cartao;
    }
}
