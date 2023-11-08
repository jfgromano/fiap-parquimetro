package br.com.fiap.postech.parquimetro.dominio.entidade;

import jakarta.persistence.*;

import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "periodos")
public class Periodo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private LocalDateTime inicio;

    private LocalDateTime fim;
    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="pedido_id", nullable=false)
    private Pedido pedido;
    private Boolean finalizado;

    public Periodo() {

    }

    public Periodo(UUID id, LocalDateTime inicio, LocalDateTime fim, Usuario usuario, Pedido pedido) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.usuario = usuario;
        this.pedido = pedido;
    }

    public UUID getId() {
        return id;
    }

    public Periodo setId(UUID id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public Periodo setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
        return this;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public Periodo setFim(LocalDateTime fim) {
        this.fim = fim;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Periodo setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Periodo setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Boolean isFinalizado() {
        return finalizado;
    }

    public Periodo setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
        return this;
    }

    public void finaliza() {
        this.finalizado = true;
    }

    public String getTempoEstacionado() {
        Duration duration = Duration.between(this.getFim(), this.getInicio());
        long HH = duration.toHours();
        long MM = duration.toMinutesPart();
        long SS = duration.toSecondsPart();
        return String.format("%02d:%02d:%02d", HH, MM, SS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return Objects.equals(id, periodo.id) && Objects.equals(inicio, periodo.inicio) && Objects.equals(fim, periodo.fim) && Objects.equals(usuario, periodo.usuario) && Objects.equals(pedido, periodo.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inicio, fim, usuario, pedido);
    }



}
