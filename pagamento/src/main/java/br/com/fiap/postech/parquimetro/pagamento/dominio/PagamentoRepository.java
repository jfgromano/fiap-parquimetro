package br.com.fiap.postech.parquimetro.pagamento.dominio;

import java.util.Optional;
import java.util.UUID;


public interface PagamentoRepository {
    public Pagamento criaAtualiza(Pagamento pagamento);
    public Optional<Pagamento> buscaPorId(UUID id);

}
