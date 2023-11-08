package br.com.fiap.postech.parquimetro.web.controller;

import br.com.fiap.postech.parquimetro.aplicacao.contato.CriaAtualizaContato;
import br.com.fiap.postech.parquimetro.aplicacao.contato.ObterContatoUsuario;
import br.com.fiap.postech.parquimetro.aplicacao.veiculo.CriaAtualizaVeiculo;
import br.com.fiap.postech.parquimetro.aplicacao.veiculo.ListarVeiculos;
import br.com.fiap.postech.parquimetro.aplicacao.veiculo.RemoverVeiculo;
import br.com.fiap.postech.parquimetro.dominio.entidade.Contato;
import br.com.fiap.postech.parquimetro.dominio.entidade.Veiculo;
import br.com.fiap.postech.parquimetro.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.parquimetro.web.form.ContatoForm;
import br.com.fiap.postech.parquimetro.web.form.VeiculoForm;
import br.com.fiap.postech.parquimetro.web.view.ContatoView;
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
@RequestMapping("/veiculos")

public class VeiculoController {
    @Autowired
    private CriaAtualizaVeiculo criaAtualizaVeiculo;

    @Autowired
    private ListarVeiculos listarVeiculos;

    @Autowired
    private RemoverVeiculo removerVeiculo;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody VeiculoForm veiculoForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Veiculo veiculo = this.criaAtualizaVeiculo.executa(authUser.getUsuario(), veiculoForm.asVeiculo());
        VeiculoView view = new VeiculoView(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(view);
    }

    @GetMapping
    public ResponseEntity<?> listar(@AuthenticationPrincipal UsuarioAutenticacao authUser) {
        List<Veiculo> retorno = this.listarVeiculos.executa(authUser.getUsuario());
        List<VeiculoView> view = retorno.stream().map(e -> new VeiculoView(e)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") UUID id, @Valid @RequestBody VeiculoForm veiculoForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Veiculo veiculo = this.criaAtualizaVeiculo.executa(authUser.getUsuario(), veiculoForm.asVeiculo(), id);
        VeiculoView view = new VeiculoView(veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") UUID id, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        this.removerVeiculo.executa(authUser.getUsuario(), id);
        return ResponseEntity.noContent().build();
    }
}
