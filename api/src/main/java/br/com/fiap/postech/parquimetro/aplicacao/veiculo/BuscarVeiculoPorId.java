package br.com.fiap.postech.parquimetro.aplicacao.veiculo;

import br.com.fiap.postech.parquimetro.aplicacao.ValidaPermissoesRecursoAction;
import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.exception.EnderecoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.exception.VeiculoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.EnderecoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarVeiculoPorId {
    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private ValidaPermissoesRecursoAction validaPermissoesRecursoAction;

    public Veiculo executa(Usuario usuario, UUID id) {
        Optional<Veiculo> veiculoEmBanco = repository.buscaPorId(id);
        if(veiculoEmBanco.isEmpty()) {
            throw new VeiculoNaoCadastradoException();
        }
        validaPermissoesRecursoAction.executa(usuario, veiculoEmBanco.get().getUsuario().getId());
        return veiculoEmBanco.get();
    }
}
