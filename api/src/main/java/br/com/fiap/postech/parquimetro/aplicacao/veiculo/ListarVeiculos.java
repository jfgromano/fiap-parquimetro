package br.com.fiap.postech.parquimetro.aplicacao.veiculo;

import br.com.fiap.postech.parquimetro.aplicacao.ValidaPermissoesRecursoAction;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.exception.VeiculoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListarVeiculos {
    @Autowired
    private VeiculoRepository repository;

    public List<Veiculo> executa(Usuario usuario) {
        return repository.buscaPorIdUsuario(usuario.getId());
    }
}
