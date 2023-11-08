package br.com.fiap.postech.parquimetro.dominio.entidade;

import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.StatusPagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.TipoPagamento;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "tipo_periodo_id")
    private TipoPeriodo tipoPeriodo;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    private Integer horas;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;

    @OneToMany(mappedBy="pedido")
    List<Pagamento> pagamentos;

    public Pedido() {

    }

    public Pedido(UUID id, TipoPeriodo tipoPeriodo, Veiculo veiculo, Integer horas, LocalDateTime data, Usuario usuario, StatusPagamento statusPagamento) {
        this.id = id;
        this.tipoPeriodo = tipoPeriodo;
        this.veiculo = veiculo;
        this.horas = horas;
        this.data = data;
        this.usuario = usuario;
        this.statusPagamento = statusPagamento;
    }

    public UUID getId() {
        return id;
    }

    public Pedido setId(UUID id) {
        this.id = id;
        return this;
    }

    public TipoPeriodo getTipoPeriodo() {
        return tipoPeriodo;
    }

    public Pedido setTipoPeriodo(TipoPeriodo tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
        return this;
    }

    public Integer getHoras() {
        return horas;
    }

    public Pedido setHoras(Integer horas) {
        this.horas = horas;
        return this;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Pedido setData(LocalDateTime data) {
        this.data = data;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pedido setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Pedido setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        return this;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public Pedido setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
        return this;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public Pedido setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
        return this;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Pedido setCartao(Cartao cartao) {
        this.cartao = cartao;
        return this;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public Pedido setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(tipoPeriodo, pedido.tipoPeriodo) && Objects.equals(horas, pedido.horas) && Objects.equals(data, pedido.data) && Objects.equals(usuario, pedido.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoPeriodo, horas, data, usuario);
    }

    public BigDecimal calcularValor() {
        return this.getTipoPeriodo().calculaValor(this.getHoras());
    }
}
