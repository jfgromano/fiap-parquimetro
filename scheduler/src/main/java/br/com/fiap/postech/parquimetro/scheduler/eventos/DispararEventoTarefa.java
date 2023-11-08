package br.com.fiap.postech.parquimetro.scheduler.eventos;

import br.com.fiap.postech.parquimetro.scheduler.dominio.TarefaAgendada;

public interface DispararEventoTarefa {
    void executa(String mensagem, String fila);
}
