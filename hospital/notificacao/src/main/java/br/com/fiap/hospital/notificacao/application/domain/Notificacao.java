package br.com.fiap.hospital.notificacao.application.domain;

public class Notificacao {
    private final String idMensagem;
    private final String categoria;
    private final String titulo;
    private final String mensagem;
    private final String nome;
    private final String email;
    private final String tell;

    public Notificacao(NotificacaoBuilder builder) {
        this.idMensagem = builder.idMensagem;
        this.categoria = builder.categoria;
        this.titulo = builder.titulo;
        this.mensagem = builder.mensagem;
        this.nome = builder.nome;
        this.email = builder.email;
        this.tell = builder.tell;
    }

    public String getIdMensagem() {
        return idMensagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTell() {
        return tell;
    }

    public static class NotificacaoBuilder {
        private String idMensagem;
        private String categoria;
        private String titulo;
        private String mensagem;
        private String nome;
        private String email;
        private String tell;

        public NotificacaoBuilder withIdMensagem (String idMensagem) {
            this.idMensagem = idMensagem;
            return this;
        }

        public NotificacaoBuilder withCategoria (String categoria) {
            this.categoria = categoria;
            return this;
        }

        public NotificacaoBuilder withTitulo (String titulo) {
            this.titulo = titulo;
            return this;
        }

        public NotificacaoBuilder withMensagem (String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public NotificacaoBuilder withNome (String nome) {
            this.nome = nome;
            return this;
        }

        public NotificacaoBuilder withEmail (String email) {
            this.email = email;
            return this;
        }

        public NotificacaoBuilder withTell (String tell) {
            this.tell = tell;
            return this;
        }

        public Notificacao build (){
            return new Notificacao(this);
        }
    }
}
