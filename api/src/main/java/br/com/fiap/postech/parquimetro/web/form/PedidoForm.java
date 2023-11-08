package br.com.fiap.postech.parquimetro.web.form;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.TipoPeriodo;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects.CartaoTipo;
import br.com.fiap.postech.parquimetro.web.validacoes.NullOrNotBlank;
import br.com.fiap.postech.parquimetro.web.validacoes.Number;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record PedidoForm(

    @br.com.fiap.postech.parquimetro.web.validacoes.UUID
    String idVeiculo,
    @NotBlank
    String tipoPeriodo,
    @Number(required = false)
    @NullOrNotBlank
    String horas,
    @Valid
    PagamentoForm pagamento
) {
    public Pedido asPedido() {

        Pedido pedido = new Pedido();
        if(horas != null) {
            pedido.setHoras(Integer.parseInt(horas));
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setId(UUID.fromString(idVeiculo));

        pedido.setVeiculo(veiculo);
        TipoPeriodo tipo = new TipoPeriodo();
        tipo.setNome(tipoPeriodo);
        pedido.setTipoPeriodo(tipo);

        return pedido;
    }
}
