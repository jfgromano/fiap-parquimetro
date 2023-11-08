package br.com.fiap.postech.parquimetro.aplicacao.pedido;

import br.com.fiap.postech.parquimetro.aplicacao.cartao.BuscarCartaoPorId;
import br.com.fiap.postech.parquimetro.eventos.processarpagamento.ProcessarPagamento;
import br.com.fiap.postech.parquimetro.aplicacao.veiculo.BuscarVeiculoPorId;
import br.com.fiap.postech.parquimetro.eventos.processarpagamento.DispararEventoProcessarPagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.*;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.StatusPagamento;
import br.com.fiap.postech.parquimetro.dominio.exception.MetodoDePagamentoInvalidoException;
import br.com.fiap.postech.parquimetro.dominio.exception.ParametroInvalidoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PedidoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.TipoPeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EfetuarPedido {

    @Autowired
    private TipoPeriodoRepository repositoryTipoPeriodo;

    @Autowired
    private PedidoRepository repositoryPedido;

    @Autowired
    private BuscarVeiculoPorId buscarVeiculoPorId;

    @Autowired
    private BuscarCartaoPorId buscarCartaoPorId;

    @Autowired
    private TransactionTemplate template;

    @Autowired
    private DispararEventoProcessarPagamento dispararEventoProcessarPagamento;

    public Pedido executa(Usuario usuario, Pedido pedido, Pagamento pagamento) {
        Optional<TipoPeriodo> tipoPeriodo = repositoryTipoPeriodo.buscaPorNome(pedido.getTipoPeriodo().getNome());
        if(tipoPeriodo.isEmpty()) {
            throw new ParametroInvalidoException("O tipo de periodo informado não é valido!");
        }

        boolean metodoDePagamentoInvalidoParaOTipoDePeriodo = !tipoPeriodo.get().getMetodosPagamento().contains(pagamento.getTipo());
        if(metodoDePagamentoInvalidoParaOTipoDePeriodo) {
            throw new MetodoDePagamentoInvalidoException();
        }

        Veiculo veiculo = buscarVeiculoPorId.executa(usuario, pedido.getVeiculo().getId());

        String tokenCartao = null;
        if(pagamento.getCartao() != null) {
            Cartao cartao = buscarCartaoPorId.executa(usuario, pagamento.getCartao().getId());
            tokenCartao = cartao.getToken();
            pedido.setCartao(cartao);
        }

        if(!tipoPeriodo.get().fixo()) {
            pedido.setHoras(1);
        }

        pedido.setTipoPeriodo(tipoPeriodo.get());
        pedido.setUsuario(usuario);
        pedido.setVeiculo(veiculo);
        pedido.setData(LocalDateTime.now());
        pedido.setStatusPagamento(StatusPagamento.PROCESSANDO);
        pedido.setTipoPagamento(pagamento.getTipo());

        repositoryPedido.criaAtualiza(pedido);

        dispararEventoProcessarPagamento.enviar(new ProcessarPagamento(pedido, pagamento.getTipo(), tokenCartao));
        return pedido;
    }
}
