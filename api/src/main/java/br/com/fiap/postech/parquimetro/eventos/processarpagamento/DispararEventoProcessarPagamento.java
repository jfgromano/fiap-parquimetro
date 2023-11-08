package br.com.fiap.postech.parquimetro.eventos.processarpagamento;

public interface DispararEventoProcessarPagamento {
    void enviar(ProcessarPagamento event);
}
