package br.com.fiap.postech.parquimetro.aplicacao.veiculo;

import br.com.fiap.postech.parquimetro.aplicacao.ValidaPermissoesRecursoAction;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.exception.VeiculoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RemoverVeiculo {
    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private BuscarVeiculoPorId buscarPorId;

    public void executa(Usuario usuario, UUID id) {
        Veiculo veiculoEmBanco = buscarPorId.executa(usuario, id);
        this.repository.remover(veiculoEmBanco);
    }
}
