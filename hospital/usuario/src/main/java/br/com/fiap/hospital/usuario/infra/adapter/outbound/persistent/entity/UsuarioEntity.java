package br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity;

import br.com.fiap.hospital.usuario.application.domain.UserType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario_tb")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idUsuario;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "senha")
    private String senha;
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "tipo")
    private UserType tipo;
    @Column(name = "CPF",  unique = true, nullable = false)
    private String CPF;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "tell")
    private String tell;

    public UsuarioEntity(String nome, String username, String senha, LocalDate dataNascimento, UserType tipo, String CPF, String email, String tell) {
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.CPF = CPF;
        this.email = email;
        this.tell = tell;
    }

    public UsuarioEntity () {}

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public UserType getTipo() {
        return tipo;
    }

    public void setTipo(UserType tipo) {
        this.tipo = tipo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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
