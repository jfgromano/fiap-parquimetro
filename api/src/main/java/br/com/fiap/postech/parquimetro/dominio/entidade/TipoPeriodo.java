package br.com.fiap.postech.parquimetro.dominio.entidade;

import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.TipoPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tipos_periodo", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nome"})
})
public class TipoPeriodo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String nome;
    private BigDecimal valorHora;
    @Enumerated(EnumType.STRING)
    private List<TipoPagamento> metodosPagamento;

    public TipoPeriodo(){

    }

    public TipoPeriodo(String nome, BigDecimal valorHora, List<TipoPagamento> metodosPagamento) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.metodosPagamento = metodosPagamento;
    }

    public UUID getId() {
        return id;
    }

    public TipoPeriodo setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoPeriodo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public TipoPeriodo setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
        return this;
    }

    public List<TipoPagamento> getMetodosPagamento() {
        return metodosPagamento;
    }

    public TipoPeriodo setMetodosPagamento(List<TipoPagamento> metodosPagamento) {
        this.metodosPagamento = metodosPagamento;
        return this;
    }

    public BigDecimal calculaValor(int horas) {
        return this.getValorHora().multiply(BigDecimal.valueOf(horas));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPeriodo that = (TipoPeriodo) o;
        return valorHora == that.valorHora && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(metodosPagamento, that.metodosPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, valorHora, metodosPagamento);
    }

    public boolean fixo() {
        return this.getNome().toLowerCase().equals("fixo");
    }
}
