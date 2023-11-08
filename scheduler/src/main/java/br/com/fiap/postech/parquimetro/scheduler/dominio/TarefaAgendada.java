package br.com.fiap.postech.parquimetro.scheduler.dominio;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tarefa_agendada")
public class TarefaAgendada {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID idPedido;
    private String nomeFila;
    private String mensagem;
    private int intervaloDeRecorrenciaEmMinutos;
    private LocalDateTime dataAgendada;
    private LocalDateTime dataDoEnvio;
    private boolean cancelada;

    public TarefaAgendada() {

    }

    public TarefaAgendada(UUID id, UUID idPedido, String nomeFila, String mensagem, int intervaloDeRecorrenciaEmMinutos, LocalDateTime dataAgendada, LocalDateTime dataDoEnvio, boolean cancelada) {
        this.id = id;
        this.idPedido = idPedido;
        this.nomeFila = nomeFila;
        this.mensagem = mensagem;
        this.intervaloDeRecorrenciaEmMinutos = intervaloDeRecorrenciaEmMinutos;
        this.dataAgendada = dataAgendada;
        this.dataDoEnvio = dataDoEnvio;
        this.cancelada = cancelada;
    }

    public UUID getId() {
        return id;
    }

    public TarefaAgendada setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNomeFila() {
        return nomeFila;
    }

    public TarefaAgendada setNomeFila(String nomeFila) {
        this.nomeFila = nomeFila;
        return this;
    }

    public String getMensagem() {
        return mensagem;
    }

    public TarefaAgendada setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public int getIntervaloDeRecorrenciaEmMinutos() {
        return intervaloDeRecorrenciaEmMinutos;
    }

    public TarefaAgendada setIntervaloDeRecorrenciaEmMinutos(int intervaloDeRecorrenciaEmMinutos) {
        this.intervaloDeRecorrenciaEmMinutos = intervaloDeRecorrenciaEmMinutos;
        return this;
    }

    public LocalDateTime getDataAgendada() {
        return dataAgendada;
    }

    public TarefaAgendada setDataAgendada(LocalDateTime dataAgendada) {
        this.dataAgendada = dataAgendada;
        return this;
    }

    public LocalDateTime getDataDoEnvio() {
        return dataDoEnvio;
    }

    public TarefaAgendada setDataDoEnvio(LocalDateTime dataDoEnvio) {
        this.dataDoEnvio = dataDoEnvio;
        return this;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public TarefaAgendada setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
        return this;
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public TarefaAgendada setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
        return this;
    }
}
