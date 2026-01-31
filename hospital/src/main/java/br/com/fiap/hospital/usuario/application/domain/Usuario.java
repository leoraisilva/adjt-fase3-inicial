package br.com.fiap.hospital.usuario.application.domain;

import java.time.LocalDate;

public class Usuario {
    private String nome;
    private String username;
    private String senha;
    private String CPF;
    private String email;
    private String tell;
    private LocalDate dataNascimento;
    private UserType tipo;

    public Usuario(UsuarioBuilder builder) {
        this.nome = builder.nome;
        this.username = builder.username;
        this.CPF = builder.CPF;
        this.email = builder.email;
        this.tell = builder.tell;
        this.senha = builder.senha;
        this.dataNascimento = builder.dataNascimento;
        this.tipo = builder.tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UserType getTipo() {
        return tipo;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return email;
    }

    public String getTell() {
        return tell;
    }

    public static class UsuarioBuilder {
        private String nome;
        private String username;
        private String senha;
        private LocalDate dataNascimento;
        private UserType tipo;
        private String CPF;
        private String email;
        private String tell;

        public UsuarioBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UsuarioBuilder withSenha(String senha) {
            this.senha = senha;
            return this;
        }

        public UsuarioBuilder withDataNascimento(LocalDate dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public UsuarioBuilder withCPF(String  CPF) {
            this.CPF = CPF;
            return this;
        }

        public UsuarioBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder withTell(String tell) {
            this.tell = tell;
            return this;
        }

        public UsuarioBuilder withUserType(UserType tipo) {
            this.tipo = tipo;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

}
