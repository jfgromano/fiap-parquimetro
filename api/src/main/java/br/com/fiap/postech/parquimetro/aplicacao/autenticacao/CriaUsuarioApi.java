package br.com.fiap.postech.parquimetro.aplicacao.autenticacao;

import br.com.fiap.postech.parquimetro.aplicacao.contato.CriaAtualizaContato;
import br.com.fiap.postech.parquimetro.aplicacao.endereco.CriaAtualizaEndereco;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.exception.RecursoJaExisteException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class CriaUsuarioApi {
    @Autowired
    private CriaAtualizaEndereco criaEndereco;
    @Autowired
    private CriaAtualizaContato criaContato;
    @Autowired
    private TransactionTemplate template;
    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario executa(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        try {
            return template.execute(status ->  {
                Usuario usuarioCriado = usuarioRepo.cria(usuario);
                criaEndereco.executa(usuarioCriado, usuario.getEndereco());
                criaContato.executa(usuarioCriado, usuario.getContato());
                return usuarioCriado;
            });
        } catch (DataIntegrityViolationException e) {
            throw new RecursoJaExisteException("Já existe um usuario com o email informado");
        }
    }
}
