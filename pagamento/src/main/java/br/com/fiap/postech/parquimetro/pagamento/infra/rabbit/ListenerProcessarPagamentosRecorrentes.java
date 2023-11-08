package br.com.fiap.postech.parquimetro.pagamento.infra.rabbit;

import br.com.fiap.postech.parquimetro.pagamento.aplicacao.ProcessarPagamentoRecorrente;
import br.com.fiap.postech.parquimetro.pagamento.eventos.MensagemPagamentoRecorrente;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerProcessarPagamentosRecorrentes {
    @Autowired
    private ProcessarPagamentoRecorrente processarPagamentoRecorrente;

    @RabbitListener(queues = Filas.IN_PROCESSAR_PAGAMENTO_RECORRENTE)
    public void receiveMessage(MensagemPagamentoRecorrente message) {
        processarPagamentoRecorrente.executa(message);
    }
}
