package br.com.fiap.postech.parquimetro.aplicacao.cartao;

import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.dominio.exception.EnderecoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.exception.RecursoJaExisteException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CriaCartao {
    @Autowired
    private CartaoRepository repository;

    public Cartao executa(Usuario usuario, Cartao cartao) {
        cartao.setUsuario(usuario);
        try {
            return repository.criaOuAtualiza(cartao);
        } catch (DataIntegrityViolationException e) {
            throw new RecursoJaExisteException("Já existe um cartão com o token informado");
        }
    }
}