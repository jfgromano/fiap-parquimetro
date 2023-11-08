package br.com.fiap.postech.parquimetro.aplicacao.recibo.dto;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record DetalhesPedidoRecibo(
        String dataPedido,
        String tipo,
        BigDecimal valorHora
) {
    public DetalhesPedidoRecibo(Pedido pedido) {
        this(
                pedido.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
                pedido.getTipoPeriodo().getNome(),
                pedido.getTipoPeriodo().getValorHora()
        );
    }
}
