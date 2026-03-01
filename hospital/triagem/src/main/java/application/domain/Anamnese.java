package application.domain;

public class Anamnese {
    private final String idAnamnese;
    private final String descricao;
    private final Intensidade dores;
    private final boolean diabete;
    private final boolean pressaoAlta;
    private final boolean coracao;
    private final String historicoFamilia;
    private final String membroFamilia;

    public Anamnese(AnamneseBuilder builder) {
        this.idAnamnese = builder.idAnamnese;
        this.descricao = builder.descricao;
        this.dores = builder.dores;
        this.diabete = builder.diabete;
        this.pressaoAlta = builder.pressaoAlta;
        this.coracao = builder.coracao;
        this.historicoFamilia = builder.historicoFamilia;
        this.membroFamilia = builder.membroFamilia;
    }

    public String getIdAnamnese() {
        return idAnamnese;
    }

    public String getDescricao() {
        return descricao;
    }

    public Intensidade getDores() {
        return dores;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public boolean isPressaoAlta() {
        return pressaoAlta;
    }

    public boolean isCoracao() {
        return coracao;
    }

    public String getHistoricoFamilia() {
        return historicoFamilia;
    }

    public String getMembroFamilia() {
        return membroFamilia;
    }

    public static class AnamneseBuilder {
        private String idAnamnese;
        private String descricao;
        private Intensidade dores;
        private boolean diabete;
        private boolean pressaoAlta;
        private boolean coracao;
        private String historicoFamilia;
        private String membroFamilia;

        public AnamneseBuilder withIdAnamnese (String idAnamnese) {
            this.idAnamnese = idAnamnese;
            return this;
        }

        public AnamneseBuilder withDescricao (String descricao) {
            this.descricao = descricao;
            return this;
        }

        public AnamneseBuilder withDores (Intensidade dores) {
            this.dores = dores;
            return this;
        }

        public AnamneseBuilder withDiabete (boolean diabete){
            this.diabete = diabete;
            return this;
        }

        public AnamneseBuilder withPressaoAlta (boolean PressaoAlta) {
            this.pressaoAlta = pressaoAlta;
            return this;
        }

        public AnamneseBuilder withCoracao (boolean Coracao) {
            this.coracao = coracao;
            return this;
        }


        public AnamneseBuilder withHistoricoFamilia (String historicoFamilia) {
            this.historicoFamilia = historicoFamilia;
            return this;
        }

        public AnamneseBuilder withMembroFamilia (String membroFamilia) {
            this.membroFamilia = membroFamilia;
            return this;
        }

        public Anamnese build () {
            return new Anamnese(this);
        }
    }
}
