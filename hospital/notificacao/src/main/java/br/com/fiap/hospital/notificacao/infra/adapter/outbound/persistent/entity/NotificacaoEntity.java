package br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notificacao_tb")
public class NotificacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idMensagem;
    @Column(name = "categoria", unique = true)
    private String categoria;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "mensagem")
    private String mensagem;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "tell")
    private String tell;

    public NotificacaoEntity(String categoria, String titulo, String mensagem, String nome, String email, String tell) {
        this.categoria = categoria;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nome = nome;
        this.email = email;
        this.tell = tell;
    }

    public NotificacaoEntity (){}

    public String getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(String idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }
}
