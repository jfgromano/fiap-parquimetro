package br.com.fiap.postech.parquimetro.aplicacao.pedido;

import br.com.fiap.postech.parquimetro.aplicacao.ValidaPermissoesRecursoAction;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.exception.PedidoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarPedidoPorId {
    @Autowired
    PedidoRepository repository;

    @Autowired
    private ValidaPermissoesRecursoAction validaPermissoesRecursoAction;

    public Pedido executa(Usuario usuario, UUID id) {
        Optional<Pedido> pedidoEmBanco = repository.buscaPorId(id);
        if(pedidoEmBanco.isEmpty()) {
            throw new PedidoNaoCadastradoException();
        }
        validaPermissoesRecursoAction.executa(usuario, pedidoEmBanco.get().getUsuario().getId());
        return pedidoEmBanco.get();
    }
}
