package br.com.fiap.postech.parquimetro.pagamento.infra.rabbit;

public class Filas {
    public static final String IN_PROCESSAR_PAGAMENTO = "pagamentos.q.processar-pagamento";
    public static final String IN_PROCESSAR_PAGAMENTO_RECORRENTE = "pagamentos.q.processar-pagamento-recorrente";
    public static final String OUT_ATUALIZAR_STATUS_PAGAMENTO = "api.q.status-pagamento";
}
