package br.com.fiap.postech.parquimetro.dominio;

public enum Notificacoes {
    PERIODO_VARIAVEL_EXPIRANDO("O seu periodo de estacionamento esta perto de expirar e sera renovado automaticamente!"),
    PERIODO_FIXO_EXPIRANDO("O seu periodo de estacionamento esta perto de expirar!");
    private final String mensagem;

    Notificacoes(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
