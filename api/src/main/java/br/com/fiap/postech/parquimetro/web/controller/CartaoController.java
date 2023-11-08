package br.com.fiap.postech.parquimetro.web.controller;

import br.com.fiap.postech.parquimetro.aplicacao.autenticacao.CriaUsuarioApi;
import br.com.fiap.postech.parquimetro.aplicacao.autenticacao.GerarTokenAutenticacaoComEmailSenha;
import br.com.fiap.postech.parquimetro.aplicacao.cartao.CriaCartao;
import br.com.fiap.postech.parquimetro.aplicacao.cartao.ListarCartoes;
import br.com.fiap.postech.parquimetro.aplicacao.cartao.RemoverCartao;
import br.com.fiap.postech.parquimetro.aplicacao.cartao.SelecionarComoCartaoPrincipal;
import br.com.fiap.postech.parquimetro.dominio.entidade.Cartao;
import br.com.fiap.postech.parquimetro.dominio.entidade.Usuario;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.parquimetro.web.form.AutenticacaoForm;
import br.com.fiap.postech.parquimetro.web.form.CartaoForm;
import br.com.fiap.postech.parquimetro.web.form.UsuarioForm;
import br.com.fiap.postech.parquimetro.web.view.AutenticacaoView;
import br.com.fiap.postech.parquimetro.web.view.CartaoView;
import br.com.fiap.postech.parquimetro.web.view.VeiculoView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {
    @Autowired
    private CriaCartao criaCartao;

    @Autowired
    private ListarCartoes listarCartoes;

    @Autowired
    private RemoverCartao removerCartao;
    @Autowired
    private SelecionarComoCartaoPrincipal selecionarComoCartaoPrincipal;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody CartaoForm cartaoForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Cartao cartao = this.criaCartao.executa(authUser.getUsuario(), cartaoForm.asCartao());
        return ResponseEntity.status(HttpStatus.CREATED).body(new CartaoView(cartao));
    }

    @PutMapping("/{id}/principal")
    public ResponseEntity<?> marcarComoPrincipal(@PathVariable("id") UUID id, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        this.selecionarComoCartaoPrincipal.executa(authUser.getUsuario(), id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") UUID id, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        this.removerCartao.executa(authUser.getUsuario(), id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> listar(@AuthenticationPrincipal UsuarioAutenticacao authUser) {
        List<Cartao> retorno = this.listarCartoes.executa(authUser.getUsuario());
        List<CartaoView> view = retorno.stream().map(e -> new CartaoView(e)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }
}
