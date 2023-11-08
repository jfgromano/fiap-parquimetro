package br.com.fiap.postech.parquimetro.aplicacao.veiculo;

import br.com.fiap.postech.parquimetro.aplicacao.contato.BuscarContatoPorId;
import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.exception.EnderecoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.exception.RecursoJaExisteException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.ContatoRepository;
import br.com.fiap.postech.parquimetro.dominio.repositorio.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CriaAtualizaVeiculo {
    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private BuscarVeiculoPorId buscarPorId;

    public Veiculo executa(Usuario usuario, Veiculo veiculo, UUID id) {
        if(id != null){
            Veiculo veiculoEmBanco = buscarPorId.executa(usuario, id);
            veiculoEmBanco.atualiza(veiculo);
            veiculo = veiculoEmBanco;
        }
        veiculo.setUsuario(usuario);

        try {
            return repository.criaOuAtualiza(veiculo);
        } catch (DataIntegrityViolationException e) {
            throw new RecursoJaExisteException("Já existe um veiculo com a placa informada");
        }
    }

    public Veiculo executa(Usuario usuario, Veiculo contato) {
        return this.executa(usuario, contato, null);
    }
}