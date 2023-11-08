package br.com.fiap.postech.parquimetro.dominio.repositorio;

import br.com.fiap.postech.parquimetro.dominio.entidade.TipoPeriodo;

import java.util.Optional;

public interface TipoPeriodoRepository {
    public Optional<TipoPeriodo> buscaPorNome(String nome);
}
