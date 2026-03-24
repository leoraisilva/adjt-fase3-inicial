package br.com.fiap.hospital.usuario.application.useCase.inbound.listUsaurio;

import br.com.fiap.hospital.usuario.application.domain.UserType;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.time.LocalDate;

public record ListUsuarioOutput(String nome, String username, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo) {
    public static Usuario toDomain(ListUsuarioOutput output) {
        return new Usuario.UsuarioBuilder()
                .withNome(output.nome)
                .withUsername(output.username)
                .withSenha(output.senha)
                .withDataNascimento(output.dataNascimento)
                .withCPF(output.CPF)
                .withEmail(output.email)
                .withTell(output.tell)
                .withUserType(output.tipo)
                .build();
    }

    public static ListUsuarioOutput fromDomain (Usuario usuario) {
        return new ListUsuarioOutput(
                usuario.getNome(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getDataNascimento(),
                usuario.getCPF(),
                usuario.getEmail(),
                usuario.getTell(),
                usuario.getTipo()
        );
    }
}
