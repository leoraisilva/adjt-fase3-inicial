package application.domain;

public class Avaliacao {
    private final String idAvaliacao;
    private final String pressao;
    private final String oxigenacao;
    private final String quadroClinico;
    private final Classificacao risco;

    public Avaliacao(AvaliacaoBuilder builder ) {
        this.idAvaliacao = builder.idAvaliacao;
        this.pressao = builder.pressao;
        this.oxigenacao = builder.oxigenacao;
        this.quadroClinico = builder.quadroClinico;
        this.risco = builder.risco;
    }

    public String getIdAvaliacao() {
        return idAvaliacao;
    }

    public String getPressao() {
        return pressao;
    }

    public String getOxigenacao() {
        return oxigenacao;
    }

    public String getQuadroClinico() {
        return quadroClinico;
    }

    public Classificacao getRisco() {
        return risco;
    }

    public static class AvaliacaoBuilder {
        private String idAvaliacao;
        private String pressao;
        private String oxigenacao;
        private String quadroClinico;
        private Classificacao risco;

        public AvaliacaoBuilder withIdAvaliacao (String idAvaliacao) {
            this.idAvaliacao = idAvaliacao;
            return this;
        }

        public AvaliacaoBuilder withPressao (String pressao) {
            this.pressao = pressao;
            return this;
        }

        public AvaliacaoBuilder withOxigenacao (String oxigenacao) {
            this.oxigenacao = oxigenacao;
            return this;
        }

        public AvaliacaoBuilder withQuadroClinico (String quadroClinico) {
            this.quadroClinico = quadroClinico;
            return this;
        }

        public AvaliacaoBuilder withRisco (Classificacao risco) {
            this.risco = risco;
            return this;
        }

        public Avaliacao build() {
            return new Avaliacao(this);
        }
    }
}
