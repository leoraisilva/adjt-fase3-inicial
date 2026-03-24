package br.com.fiap.hospital.usuario.application.useCase.inbound.getUsuario;

import br.com.fiap.hospital.usuario.application.domain.UserType;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.time.LocalDate;

public record GetUsuarioOutput(String nome, String username, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo) {
    public static Usuario toDomain(GetUsuarioOutput output) {
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

    public static GetUsuarioOutput fromDomain (Usuario usuario) {
        return new GetUsuarioOutput(
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
