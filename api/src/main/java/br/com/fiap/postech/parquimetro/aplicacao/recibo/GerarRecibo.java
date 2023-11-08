package br.com.fiap.postech.parquimetro.aplicacao.recibo;

import br.com.fiap.postech.parquimetro.aplicacao.pedido.BuscarPedidoPorId;
import br.com.fiap.postech.parquimetro.aplicacao.periodo.BuscarPeriodoDoPedido;
import br.com.fiap.postech.parquimetro.aplicacao.recibo.dto.*;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.Periodo;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.exception.ReciboIndisponivelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class GerarRecibo {

    @Autowired
    private BuscarPedidoPorId buscarPedidoPorId;
    @Autowired
    BuscarPeriodoDoPedido buscarPeriodoDoPedido;

    public Recibo executa(Usuario usuario, UUID idPedido) {
        Pedido pedido = buscarPedidoPorId.executa(usuario, idPedido);
        Periodo periodo = buscarPeriodoDoPedido.executa(pedido);

        if(!periodo.isFinalizado()) {
            throw new ReciboIndisponivelException();
        }
        List<Pagamento> pagamentos = pedido.getPagamentos();
        BigDecimal valor = new BigDecimal("0");
        for(Pagamento pagamento: pagamentos) {
            valor = valor.add(pagamento.getValor());
        }

        PagamentoRecibo pagamento = new PagamentoRecibo(
            pedido.getTipoPagamento().name(),
            new CartaoRecibo(pedido.getCartao()),
            valor
        );

        return new Recibo(
                new DetalhesPedidoRecibo(pedido),
                new PeriodoRecibo(periodo),
                new VeiculoRecibo(pedido.getVeiculo()),
                pagamento
        );
    }
}
