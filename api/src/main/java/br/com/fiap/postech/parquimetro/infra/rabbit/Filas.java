package br.com.fiap.postech.parquimetro.infra.rabbit;

public class Filas {
    public static final String OUT_PROCESSAR_PAGAMENTO = "pagamentos.q.processar-pagamento";
    public static final String OUT_CANCELAR_TAREFAS_AGENDADAS = "scheduler.q.cancelar-eventos";
    public static final String OUT_AGENDAR_TAREFAS = "scheduler.q.agendar-evento";
    public static final String IN_ATUALIZAR_STATUS_PAGAMENTO = "api.q.status-pagamento";
    public static final String OUT_NOTIFICACOES = "notificacoes.q.enviar";
    public static final String OUT_PROCESSAR_PAGAMENTO_RECORRENTE = "pagamentos.q.processar-pagamento-recorrente";
}
