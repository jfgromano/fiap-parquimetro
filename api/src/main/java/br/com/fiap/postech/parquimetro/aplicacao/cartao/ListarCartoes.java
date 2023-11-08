package br.com.fiap.postech.parquimetro.aplicacao.cartao;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.repositorio.CartaoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarCartoes {
    @Autowired
    private CartaoRepository repository;

    public List<Cartao> executa(Usuario usuario) {
        return repository.buscaPorIdUsuario(usuario.getId());
    }
}
