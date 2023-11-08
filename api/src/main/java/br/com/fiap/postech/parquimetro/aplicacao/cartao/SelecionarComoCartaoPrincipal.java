package br.com.fiap.postech.parquimetro.aplicacao.cartao;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.repositorio.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.UUID;

@Service
public class SelecionarComoCartaoPrincipal {
    @Autowired
    private CartaoRepository repository;

    @Autowired
    private BuscarCartaoPorId buscarPorId;

    @Autowired
    private TransactionTemplate template;

    public void executa(Usuario usuario, UUID id) {
        template.execute(status ->  {
            repository.removerFlagCartaoPrincipal(usuario.getId());
            Cartao cartao = buscarPorId.executa(usuario, id);
            cartao.setPrincipal(true);
            repository.criaOuAtualiza(cartao);
            return cartao;
        });
    }
}
