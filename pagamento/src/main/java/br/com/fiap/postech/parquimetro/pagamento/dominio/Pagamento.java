package br.com.fiap.postech.parquimetro.pagamento.dominio;

import br.com.fiap.postech.parquimetro.pagamento.dominio.valueobjects.TipoPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String CartaoToken;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
    private BigDecimal valor;
    private String status;
    private String dadosPagamento;
    private LocalDateTime dataAprovacao;
    private boolean recorrente;
    private UUID pedidoId;

    public Pagamento() {

    }

    public Pagamento(UUID id, String cartaoToken, TipoPagamento tipoPagamento, BigDecimal valor, String status, String dadosPagamento, LocalDateTime dataAprovacao, UUID pedidoId) {
        this.id = id;
        CartaoToken = cartaoToken;
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.status = status;
        this.dadosPagamento = dadosPagamento;
        this.dataAprovacao = dataAprovacao;
        this.pedidoId = pedidoId;
    }

    public UUID getId() {
        return id;
    }

    public Pagamento setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCartaoToken() {
        return CartaoToken;
    }

    public Pagamento setCartaoToken(String cartaoToken) {
        CartaoToken = cartaoToken;
        return this;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public Pagamento setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Pagamento setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Pagamento setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDadosPagamento() {
        return dadosPagamento;
    }

    public Pagamento setDadosPagamento(String dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
        return this;
    }

    public LocalDateTime getDataAprovacao() {
        return dataAprovacao;
    }

    public Pagamento setDataAprovacao(LocalDateTime dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
        return this;
    }

    public UUID getPedidoId() {
        return pedidoId;
    }

    public Pagamento setPedidoId(UUID pedidoId) {
        this.pedidoId = pedidoId;
        return this;
    }

    public boolean isRecorrente() {
        return recorrente;
    }

    public Pagamento setRecorrente(boolean recorrente) {
        this.recorrente = recorrente;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id) && Objects.equals(CartaoToken, pagamento.CartaoToken) && Objects.equals(tipoPagamento, pagamento.tipoPagamento) && Objects.equals(valor, pagamento.valor) && Objects.equals(status, pagamento.status) && Objects.equals(dadosPagamento, pagamento.dadosPagamento) && Objects.equals(dataAprovacao, pagamento.dataAprovacao) && Objects.equals(pedidoId, pagamento.pedidoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, CartaoToken, tipoPagamento, valor, status, dadosPagamento, dataAprovacao, pedidoId);
    }
}
