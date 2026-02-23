package br.com.fiap.hospital.usuario.application.domain;

import java.time.LocalDate;

public class DefaultUsuarioFactory implements UsuarioFactory{

    public DefaultUsuarioFactory () {}
    @Override
    public Usuario usuarioFactory(String nome, String username, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo) {
        return new Usuario.UsuarioBuilder()
                .withNome(nome)
                .withUsername(username)
                .withSenha(senha)
                .withDataNascimento(dataNascimento)
                .withCPF(CPF)
                .withEmail(email)
                .withTell(tell)
                .withUserType(tipo)
                .build();
    }
}
