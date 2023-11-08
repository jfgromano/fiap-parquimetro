package br.com.fiap.postech.parquimetro.aplicacao.recibo.dto;

public record Recibo(
        DetalhesPedidoRecibo detalhes,
        PeriodoRecibo periodo,
        VeiculoRecibo veiculo,
        PagamentoRecibo pagamento
) {
}
