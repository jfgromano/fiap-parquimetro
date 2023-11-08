package br.com.fiap.postech.parquimetro.notificacoes.infra.rabbit;

import br.com.fiap.postech.parquimetro.notificacoes.aplicacao.EnviaEmail;
import br.com.fiap.postech.parquimetro.notificacoes.eventos.NotificacaoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListenerEnviarNotificacaoRabbit {
    @Autowired
    EnviaEmail enviaEmail;

    @RabbitListener(queues = Filas.IN_NOTIFICACOES)
    public void receiveMessage(NotificacaoEvent event) {
        enviaEmail.executa(event);
    }
}