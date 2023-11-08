package br.com.fiap.postech.parquimetro.aplicacao.periodo;

import br.com.fiap.postech.parquimetro.dominio.entidade.Pedido;
import br.com.fiap.postech.parquimetro.dominio.entidade.Periodo;
import br.com.fiap.postech.parquimetro.dominio.exception.PeriodoEstacionamentoNaoCadastradoException;
import br.com.fiap.postech.parquimetro.dominio.repositorio.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPeriodoDoPedido {
    @Autowired
    PeriodoRepository periodoRepository;

    public Periodo executa(Pedido pedido) {
        Optional<Periodo> optPeriodo = periodoRepository.buscaPorIdPedido(pedido.getId());
        if(optPeriodo.isEmpty()) {
            throw new PeriodoEstacionamentoNaoCadastradoException();
        }
        return optPeriodo.get();
    }
}
