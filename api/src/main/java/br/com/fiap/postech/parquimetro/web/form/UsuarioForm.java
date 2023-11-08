package br.com.fiap.postech.parquimetro.web.form;

import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.Sexo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record UsuarioForm (
    @NotBlank
    String email,
    @NotBlank
    String senha,
    @NotBlank
    String nome,
    @CPF
    String cpf,
    @NotBlank
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "deve ser uma data no formato dd/mm/yyyy")
    String dataDeNascimento,
    @NotBlank
    @Pattern(regexp = "^(M|F)$", message = "deve ser M ou F")
    String sexo,
    @Valid
    EnderecoForm endereco,
    @Valid
    ContatoForm contato
) {
    public Usuario asUsuario() {
        Usuario usuario = new Usuario(
                this.email,
                this.senha,
                this.nome,
                this.cpf,
                converterData(this.dataDeNascimento),
                Sexo.buscarPorSigla(this.sexo)
        );
        usuario.setEndereco(endereco.asEndereco());
        usuario.setContato(contato.asContato());
        return usuario;
    }

    private LocalDate converterData(String dataDeNascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataDeNascimento, formatter);
    }
}
