package br.com.fiap.postech.parquimetro.aplicacao.cartao;

import br.com.fiap.postech.parquimetro.aplicacao.ValidaPermissoesRecursoAction;
import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.exception.CartaoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.exception.VeiculoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.CartaoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarCartaoPorId {
    @Autowired
    private CartaoRepository repository;

    @Autowired
    private ValidaPermissoesRecursoAction validaPermissoesRecursoAction;

    public Cartao executa(Usuario usuario, UUID id) {
        Optional<Cartao> cartaoEmBanco = repository.buscaPorId(id);
        if(cartaoEmBanco.isEmpty()) {
            throw new CartaoNaoCadastradoException();
        }
        validaPermissoesRecursoAction.executa(usuario, cartaoEmBanco.get().getUsuario().getId());
        return cartaoEmBanco.get();
    }
}
