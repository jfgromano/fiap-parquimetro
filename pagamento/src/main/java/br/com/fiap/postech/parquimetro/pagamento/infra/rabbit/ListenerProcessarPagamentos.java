package br.com.fiap.postech.parquimetro.pagamento.infra.rabbit;

import br.com.fiap.postech.parquimetro.pagamento.aplicacao.ProcessarPagamento;
import br.com.fiap.postech.parquimetro.pagamento.dominio.Pagamento;
import br.com.fiap.postech.parquimetro.pagamento.eventos.MensagemProcessarPagamento;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerProcessarPagamentos {
    @Autowired
    private ProcessarPagamento processarPagamento;

    @RabbitListener(queues = Filas.IN_PROCESSAR_PAGAMENTO)
    public void receiveMessage(MensagemProcessarPagamento message) {
        Pagamento pagamento = new Pagamento();
        pagamento.setPedidoId(message.idPedido());
        pagamento.setTipoPagamento(message.tipoPagamento());
        pagamento.setValor(message.valor());
        pagamento.setCartaoToken(message.tokenCartao());
        pagamento.setRecorrente(message.recorrente());
        processarPagamento.executa(pagamento);
    }
}
