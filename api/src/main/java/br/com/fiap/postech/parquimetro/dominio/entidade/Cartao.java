package br.com.fiap.postech.parquimetro.dominio.entidade;

import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.CartaoTipo;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cartoes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"token"})
})
public class Cartao {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private CartaoTipo tipo;
    private String ultimosQuatroDigitos;
    private String token;
    private Boolean principal;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    public Cartao(){}

    public Cartao(String token, String ultimosQuatroDigitos, CartaoTipo tipo, boolean principal) {
        this.token = token;
        this.ultimosQuatroDigitos = ultimosQuatroDigitos;
        this.tipo = tipo;
        this.principal = principal;
    }

    public UUID getId() {
        return id;
    }

    public Cartao setId(UUID id) {
        this.id = id;
        return this;
    }

    public CartaoTipo getTipo() {
        return tipo;
    }

    public Cartao setTipo(CartaoTipo tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getUltimosQuatroDigitos() {
        return ultimosQuatroDigitos;
    }

    public Cartao setUltimosQuatroDigitos(String ultimosQuatroDigitos) {
        this.ultimosQuatroDigitos = ultimosQuatroDigitos;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Cartao setToken(String token) {
        this.token = token;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Cartao setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Boolean isPrincipal() {
        return principal;
    }

    public Cartao setPrincipal(boolean principal) {
        this.principal = principal;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartao cartao = (Cartao) o;
        return Objects.equals(id, cartao.id) && tipo == cartao.tipo && Objects.equals(ultimosQuatroDigitos, cartao.ultimosQuatroDigitos) && Objects.equals(token, cartao.token) && Objects.equals(usuario, cartao.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, ultimosQuatroDigitos, token, usuario);
    }
}
