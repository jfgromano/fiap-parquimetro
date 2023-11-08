package br.com.fiap.postech.parquimetro.aplicacao.cartao;

import br.com.fiap.postech.parquimetro.aplicacao.veiculo.BuscarVeiculoPorId;
import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.repositorio.CartaoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RemoverCartao {
    @Autowired
    private CartaoRepository repository;

    @Autowired
    private BuscarCartaoPorId buscarPorId;

    public void executa(Usuario usuario, UUID id) {
        Cartao cartao = buscarPorId.executa(usuario, id);
        this.repository.remover(cartao);
    }
}
