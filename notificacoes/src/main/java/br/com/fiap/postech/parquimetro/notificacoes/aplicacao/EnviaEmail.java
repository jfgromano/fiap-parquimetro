package br.com.fiap.postech.parquimetro.notificacoes.aplicacao;

import br.com.fiap.postech.parquimetro.notificacoes.eventos.NotificacaoEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EnviaEmail {
    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    @Autowired
    private ObjectMapper objectMapper;

    public void executa(NotificacaoEvent event) {
        try {
            Map<String, Object> conteudo = objectMapper.readValue(event.conteudo(), Map.class);

            String destino = (String) conteudo.get("email");
            String assunto = (String) conteudo.get("assunto");
            String corpo = (String) conteudo.get("corpo");

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(remetente);
            message.setTo(destino);
            message.setSubject(assunto);
            message.setText(corpo);

            emailSender.send(message);
        }catch (Exception e) {
            throw new RuntimeException("Falha ao enviar email", e);
        }

    }
}
