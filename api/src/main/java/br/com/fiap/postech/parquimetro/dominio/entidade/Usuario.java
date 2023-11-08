package br.com.fiap.postech.parquimetro.dominio.entidade;

import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.Sexo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private LocalDate dataDeNascimento;
    private Sexo sexo;
    private String email;
    private String senha;
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    private Contato contato;

    @OneToMany(mappedBy="usuario")
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy="usuario")
    private List<Cartao> cartoes;

    @OneToMany(mappedBy="usuario")
    private List<Pedido> pedidos;

    public Usuario() {

    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String email, String senha, String nome, String cpf, LocalDate dataDeNascimento, Sexo sexo) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
    }

    public UUID getId() {
        return id;
    }

    public Usuario setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getDataDeNascimentoString() {
        return this.getDataDeNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Usuario setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Usuario setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Usuario setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Usuario setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Contato getContato() {
        return contato;
    }

    public Usuario setContato(Contato contato) {
        this.contato = contato;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, senha);
    }
}
