package br.com.fiap.postech.parquimetro.dominio;

public enum MensagensNotificacao {
    PERTO_EXPIRACAO("Periodo Parquimetro", "Seu periodo de estacionamento esta perto de expirar!"),
    PERIODO_VARIAVEL("Periodo Parquimetro", "Seu periodo variavel de estacionamento começõu e ira renovar automaticamente a cada hora!");

    private final String msg;
    private final String assunto;
    MensagensNotificacao(String assunto, String msg) {
        this.assunto = assunto;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getAssunto() {
        return assunto;
    }
}
