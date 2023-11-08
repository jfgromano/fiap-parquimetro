package br.com.fiap.postech.parquimetro.dominio.entidade;

import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.TipoPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    private UUID id;
    private TipoPagamento tipo;
    private BigDecimal valor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartao_id", referencedColumnName = "id")
    private Cartao cartao;

    @ManyToOne
    @JoinColumn(name="pedido_id", nullable=false)
    private Pedido pedido;

    public Pagamento() {

    }

    public Pagamento(TipoPagamento tipo, BigDecimal valor, Cartao cartao, Pedido pedido) {
        this.tipo = tipo;
        this.valor = valor;
        this.cartao = cartao;
        this.pedido = pedido;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public Pagamento setTipo(TipoPagamento tipo) {
        this.tipo = tipo;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Pagamento setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Pagamento setCartao(Cartao cartao) {
        this.cartao = cartao;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Pagamento setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public Pagamento setId(UUID id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) && tipo == pagamento.tipo && Objects.equals(valor, pagamento.valor) && Objects.equals(cartao, pagamento.cartao) && Objects.equals(pedido, pagamento.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, valor, cartao, pedido);
    }
}
