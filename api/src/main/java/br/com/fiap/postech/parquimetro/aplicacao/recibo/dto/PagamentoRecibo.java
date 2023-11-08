package br.com.fiap.postech.parquimetro.aplicacao.recibo.dto;

import java.math.BigDecimal;

public record PagamentoRecibo(String tipoPagamento, CartaoRecibo cartao, BigDecimal valor) {
}
