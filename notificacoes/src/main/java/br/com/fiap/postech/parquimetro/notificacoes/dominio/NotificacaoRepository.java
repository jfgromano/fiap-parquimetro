package br.com.fiap.postech.parquimetro.notificacoes.dominio;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NotificacaoRepository {
    Notificacao criaAtualiza(Notificacao notificacao);
}
