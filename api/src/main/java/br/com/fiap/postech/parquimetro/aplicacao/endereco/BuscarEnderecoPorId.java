package br.com.fiap.postech.parquimetro.aplicacao.endereco;

import br.com.fiap.postech.parquimetro.aplicacao.ValidaPermissoesRecursoAction;
import br.com.fiap.postech.parquimetro.dominio.entidade.Endereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.exception.EnderecoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarEnderecoPorId {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ValidaPermissoesRecursoAction validaPermissoesRecursoAction;

    public Endereco executa(Usuario usuario, UUID id) {
        Optional<Endereco> enderecoEmBanco = enderecoRepository.buscaPorId(id);
        if(enderecoEmBanco.isEmpty()) {
            throw new EnderecoNaoCadastradoException();
        }
        validaPermissoesRecursoAction.executa(usuario, enderecoEmBanco.get().getUsuario().getId());
        return enderecoEmBanco.get();
    }
}