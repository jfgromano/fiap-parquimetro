package br.com.fiap.postech.parquimetro.notificacoes.dominio;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notificacoes")
public class Notificacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String conteudo;
    private LocalDateTime dataEnviada;
    private UUID idPedido;

    public Notificacao() {

    }

    public UUID getId() {
        return id;
    }

    public Notificacao setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Notificacao setConteudo(String conteudo) {
        this.conteudo = conteudo;
        return this;
    }

    public LocalDateTime getDataEnviada() {
        return dataEnviada;
    }

    public Notificacao setDataEnviada(LocalDateTime dataEnviada) {
        this.dataEnviada = dataEnviada;
        return this;
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public Notificacao setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
        return this;
    }
}
