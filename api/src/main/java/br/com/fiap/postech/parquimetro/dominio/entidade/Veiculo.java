package br.com.fiap.postech.parquimetro.dominio.entidade;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "veiculos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"placa"})
})
public class Veiculo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String placa;
    private String cor;
    private String marca;
    private String modelo;
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    public Veiculo() {

    }

    public Veiculo(String placa, String cor, String marca, String modelo) {
        this.placa = placa;
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
    }

    public UUID getId() {
        return id;
    }

    public Veiculo setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getPlaca() {
        return placa;
    }

    public Veiculo setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public String getCor() {
        return cor;
    }

    public Veiculo setCor(String cor) {
        this.cor = cor;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public Veiculo setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Veiculo setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Veiculo setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public void atualiza(Veiculo veiculo) {
        this.setPlaca(veiculo.placa);
        this.setCor(veiculo.getCor());
        this.setMarca(veiculo.getMarca());
        this.setModelo(veiculo.getModelo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) && Objects.equals(placa, veiculo.placa) && Objects.equals(cor, veiculo.cor) && Objects.equals(marca, veiculo.marca) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(usuario, veiculo.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placa, cor, marca, modelo, usuario);
    }
}
