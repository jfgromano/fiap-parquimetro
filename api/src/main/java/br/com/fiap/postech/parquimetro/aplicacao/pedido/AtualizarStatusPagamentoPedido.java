package br.com.fiap.postech.parquimetro.aplicacao.pedido;

import br.com.fiap.postech.parquimetro.dominio.repositorio.PagamentoRepository;
import br.com.fiap.postech.parquimetro.eventos.processarpagamento.StatusPagamentoProcessado;
import br.com.fiap.postech.parquimetro.aplicacao.periodo.FinalizarPeriodoDeEstacionamento;
import br.com.fiap.postech.parquimetro.aplicacao.periodo.IniciarPeriodoEstacionamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.*;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.StatusPagamento;
import br.com.fiap.postech.parquimetro.dominio.exception.PedidoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;

@Service
public class AtualizarStatusPagamentoPedido {
    @Autowired
    private PedidoRepository repositoryPedido;

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private TransactionTemplate template;

    @Autowired
    IniciarPeriodoEstacionamento iniciarPeriodoEstacionamento;

    @Autowired
    FinalizarPeriodoDeEstacionamento finalizarPeriodoDeEstacionamento;
    public void executa(StatusPagamentoProcessado status) {
        Optional<Pedido> pedidoEmBanco = repositoryPedido.buscaPorId(status.pedidoId());
        if(pedidoEmBanco.isEmpty()) {
            throw new PedidoNaoCadastradoException();
        }

        Pedido pedido = pedidoEmBanco.get();
        pedido.setStatusPagamento(status.status());
        Pagamento pagamento = status.asPagamento();
        pagamento.setPedido(pedido);
        pagamento.setCartao(pedido.getCartao());

        template.execute(s ->  {
            repositoryPedido.criaAtualiza(pedido);
            pagamentoRepository.criaAtualiza(pagamento);

            if(status.status() == StatusPagamento.ERRO) {
                finalizarPeriodoDeEstacionamento.executa(pedido.getId(), pedido.getUsuario());
            }

            if(status.status() == StatusPagamento.CONCLUIDO && !status.recorrente()) {
                iniciarPeriodoEstacionamento.executa(pedido, status.id());
            }
            return null;
        });
    }
}
