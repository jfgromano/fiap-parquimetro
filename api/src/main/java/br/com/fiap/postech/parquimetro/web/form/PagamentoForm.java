package br.com.fiap.postech.parquimetro.web.form;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pagamento;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.TipoPagamento;
import br.com.fiap.postech.parquimetro.dominio.exception.ParametroInvalidoException;
import br.com.fiap.postech.parquimetro.web.validacoes.EnumValida;

import java.util.UUID;

public record PagamentoForm(

    @br.com.fiap.postech.parquimetro.web.validacoes.UUID
    String idCartao,
    @EnumValida(enumClass = TipoPagamento.class)
    String tipoPagamento
) {
    public Pagamento asPagamento() {
        Pagamento p = new Pagamento();
        p.setTipo(TipoPagamento.valueOf(tipoPagamento.toUpperCase()));

        if(p.getTipo() != TipoPagamento.PIX) {
            if(idCartao == null) {
                throw new ParametroInvalidoException("Para pagamentos com cartao é necessario informar o id do cartao desejado!");
            }else {
                Cartao c = new Cartao();
                c.setId(UUID.fromString(idCartao));
                p.setCartao(c);
            }
        }
        return p;
    }
}
