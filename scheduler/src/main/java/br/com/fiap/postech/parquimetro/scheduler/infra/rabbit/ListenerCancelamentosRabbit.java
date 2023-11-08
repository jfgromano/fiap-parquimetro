package br.com.fiap.postech.parquimetro.scheduler.infra.rabbit;

import br.com.fiap.postech.parquimetro.scheduler.aplicacao.CancelarTarefasDoPedido;
import br.com.fiap.postech.parquimetro.scheduler.eventos.CancelamentoTarefaEvent;
import br.com.fiap.postech.parquimetro.scheduler.eventos.ListenerCancelamento;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerCancelamentosRabbit implements ListenerCancelamento {

    @Autowired
    CancelarTarefasDoPedido cancelarTarefasDoPedido;
    @RabbitListener(queues = Filas.IN_CANCELAMENTOS)
    public void apply(CancelamentoTarefaEvent cancelamentoTarefaEvent) {
        cancelarTarefasDoPedido.executa(cancelamentoTarefaEvent.idPedido());
    }
}
