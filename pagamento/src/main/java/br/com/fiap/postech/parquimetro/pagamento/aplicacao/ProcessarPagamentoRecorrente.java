package br.com.fiap.postech.parquimetro.pagamento.aplicacao;

import br.com.fiap.postech.parquimetro.pagamento.dominio.Pagamento;
import br.com.fiap.postech.parquimetro.pagamento.dominio.PagamentoRepository;
import br.com.fiap.postech.parquimetro.pagamento.eventos.MensagemPagamentoRecorrente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessarPagamentoRecorrente {
    @Autowired
    PagamentoRepository repository;

    @Autowired
    ProcessarPagamento processarPagamento;

    public void executa(MensagemPagamentoRecorrente message) {
        Optional<Pagamento> optPagamento = repository.buscaPorId(message.idPagamentoBase());
        if(optPagamento.isEmpty()) {
            throw new RuntimeException("Pagamento inicial nao encontrado!");
        }

        Pagamento pagamentoBase = optPagamento.get();
        Pagamento pagamentoRecorrente = new Pagamento();
        pagamentoRecorrente.setRecorrente(true);
        pagamentoRecorrente.setTipoPagamento(pagamentoBase.getTipoPagamento());
        pagamentoRecorrente.setCartaoToken(pagamentoBase.getCartaoToken());
        pagamentoRecorrente.setValor(pagamentoBase.getValor());
        pagamentoRecorrente.setPedidoId(pagamentoBase.getPedidoId());
        processarPagamento.executa(pagamentoRecorrente);
    }
}
