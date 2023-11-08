package br.com.fiap.postech.parquimetro.pagamento.aplicacao;

import br.com.fiap.postech.parquimetro.pagamento.dominio.*;
import br.com.fiap.postech.parquimetro.pagamento.eventos.DispararEventoStatusPagamento;
import br.com.fiap.postech.parquimetro.pagamento.eventos.StatusPagamentoProcessado;
import br.com.fiap.postech.parquimetro.pagamento.dominio.valueobjects.StatusPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
public class ProcessarPagamento {
    @Autowired
    private DispararEventoStatusPagamento dispararEventoStatusPagamento;

    @Autowired
    private JsonConverter jsonConverter;

    @Autowired
    PagamentoRepository pagamentoRepository;

    public void executa(Pagamento pagamento) {
        //Simulando comunicação com o gateway e processando pagamento
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(5000, 15000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pagamento.setStatus(StatusPagamento.CONCLUIDO.name());
        pagamento.setDataAprovacao(LocalDateTime.now());

        pagamentoRepository.criaAtualiza(pagamento);
        dispararEventoStatusPagamento.enviar(jsonConverter.toJson(new StatusPagamentoProcessado(pagamento)));
    }
}
