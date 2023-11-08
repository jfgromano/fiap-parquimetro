package br.com.fiap.postech.parquimetro.web.controller;

import br.com.fiap.postech.parquimetro.aplicacao.pedido.BuscarPedidoPorId;
import br.com.fiap.postech.parquimetro.aplicacao.pedido.EfetuarPedido;
import br.com.fiap.postech.parquimetro.aplicacao.recibo.GerarRecibo;
import br.com.fiap.postech.parquimetro.aplicacao.periodo.FinalizarPeriodoDeEstacionamento;
import br.com.fiap.postech.parquimetro.aplicacao.recibo.dto.Recibo;
import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.parquimetro.web.form.PedidoForm;
import br.com.fiap.postech.parquimetro.web.view.PedidoView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private EfetuarPedido efetuarPedido;

    @Autowired
    private BuscarPedidoPorId buscaPedido;

    @Autowired
    private FinalizarPeriodoDeEstacionamento finalizarPeriodoDeEstacionamento;

    @Autowired
    private GerarRecibo gerarRecibo;

    @PostMapping
    public ResponseEntity<?> efetuarPedido(@Valid @RequestBody PedidoForm pedidoForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Pedido pedido = this.efetuarPedido.executa(
                authUser.getUsuario(),
                pedidoForm.asPedido(),
                pedidoForm.pagamento().asPagamento()
        );

        PedidoView view = new PedidoView(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(view);
    }

    @PostMapping("/{id}/finalizar")
    public ResponseEntity<?> finalizarPedidoVariavel(@PathVariable("id") UUID idPedido, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        this.finalizarPeriodoDeEstacionamento.executa(
                idPedido,
                authUser.getUsuario()
        );
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> statusPedido(@PathVariable("id") UUID idPedido, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Pedido pedido = buscaPedido.executa(authUser.getUsuario(),
                idPedido
        );
        PedidoView view = new PedidoView(pedido);
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }

    @GetMapping("/{id}/recibo")
    public ResponseEntity<?> reciboPedido(@PathVariable("id") UUID idPedido, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Recibo recibo = gerarRecibo.executa(authUser.getUsuario(),
                idPedido
        );
        return ResponseEntity.status(HttpStatus.OK).body(recibo);
    }
}
