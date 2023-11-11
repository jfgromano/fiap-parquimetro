package br.com.fiap.postech.parquimetro.aplicacao.endereco;

import br.com.fiap.postech.parquimetro.aplicacao.PaginacaoOutput;
import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.exception.EnderecoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObterEnderecoUsuario {
    @Autowired
    private EnderecoRepository repository;

    public Endereco executa(Usuario usuario) {
        Optional<Endereco> endereco = this.repository.buscaPorIdUsuario(usuario.getId());
        if(endereco.isEmpty()) {
            throw new EnderecoNaoCadastradoException();
        }
        return endereco.get();
    }
}
