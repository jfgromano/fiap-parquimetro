package br.com.fiap.postech.parquimetro.infra.repository;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.TipoPeriodo;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.repositorio.CartaoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.TipoPeriodoRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipoPeriodoRepositoryPostgresql extends JpaRepository<TipoPeriodo, UUID>, TipoPeriodoRepository {
    public default Optional<TipoPeriodo> buscaPorNome(String nome) {
        TipoPeriodo tipo = new TipoPeriodo();
        tipo.setNome(nome);
        return findOne(Example.of(tipo));
    }
}
