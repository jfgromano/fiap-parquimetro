package br.com.fiap.postech.parquimetro.infra.rabbit;

import br.com.fiap.postech.parquimetro.aplicacao.pedido.AtualizarStatusPagamentoPedido;
import br.com.fiap.postech.parquimetro.eventos.processarpagamento.StatusPagamentoProcessado;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerStatusPedidoRabbit {
    @Autowired
    AtualizarStatusPagamentoPedido atualizarStatusPagamentoPedido;

    @RabbitListener(queues = Filas.IN_ATUALIZAR_STATUS_PAGAMENTO)
    public void receiveMessage(StatusPagamentoProcessado status) {
        atualizarStatusPagamentoPedido.executa(status);
    }
}