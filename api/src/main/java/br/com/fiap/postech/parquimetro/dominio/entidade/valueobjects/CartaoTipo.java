package br.com.fiap.postech.parquimetro.dominio.entidade.valueobjects;

public enum CartaoTipo {
    DEBITO("debito"),
    CREDITO("credito");

    private final String tipo;

    CartaoTipo(String tipo) {
        this.tipo = tipo;
    }

    public static CartaoTipo buscarPorTipo(String tipo) {
        if(tipo == null) {
            return null;
        }
        for (CartaoTipo e: CartaoTipo.values()) {
            if(e.tipo.contentEquals(tipo.toLowerCase())) {
                return e;
            }
        }
        return null;
    }

    public String getTipo() {
        return tipo;
    }
}
