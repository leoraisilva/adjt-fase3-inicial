package application.domain;

public class Triagem {
    private final String idTriagem;
    private final String paciente;
    private final String responsavel;
    private final Anamnese anamnese;
    private final Avaliacao avaliacao;

    public Triagem(TriagemBuilder builder) {
        this.idTriagem = builder.idTriagem;
        this.paciente = builder.paciente;
        this.responsavel = builder.responsavel;
        this.anamnese = builder.anamnese;
        this.avaliacao = builder.avaliacao;
    }

    public String getIdTriagem() {
        return idTriagem;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public static class TriagemBuilder {
        private String idTriagem;
        private String paciente;
        private String responsavel;
        private Anamnese anamnese;
        private Avaliacao avaliacao;

        public TriagemBuilder withIdTriagem (String idTriagem) {
            this.idTriagem = idTriagem;
            return this;
        }

        public TriagemBuilder withPaciente (String paciente) {
            this.paciente = paciente;
            return this;
        }

        public TriagemBuilder withResponsavel (String responsavel) {
            this.responsavel = responsavel;
            return this;
        }

        public TriagemBuilder withAnamnese (Anamnese anamnese) {
            this.anamnese = anamnese;
            return this;
        }

        public TriagemBuilder withAvaliacao (Avaliacao avaliacao) {
            this.avaliacao = avaliacao;
            return this;
        }

        public Triagem build () {
            return new Triagem(this);
        }

    }
}
