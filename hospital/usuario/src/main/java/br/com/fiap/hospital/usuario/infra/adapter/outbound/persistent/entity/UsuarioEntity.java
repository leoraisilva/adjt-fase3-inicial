package br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity;

import br.com.fiap.hospital.usuario.application.domain.UserType;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario_tb")
public class UsuarioEntity implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if (this.tipo.equals(UserType.MEDICO)) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_MEDICO")
            );
        }

        else if (this.tipo.equals(UserType.ENFERMEIRO)) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ENFERMEIRO")
            );
        }

        return List.of(
                new SimpleGrantedAuthority("ROLE_PACIENTE")
        );
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
