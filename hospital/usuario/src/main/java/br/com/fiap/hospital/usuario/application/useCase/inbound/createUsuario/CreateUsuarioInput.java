package br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario;

import br.com.fiap.hospital.usuario.application.domain.UserType;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.time.LocalDate;

public record CreateUsuarioInput(String nome, String username, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo) {
    public static Usuario toDomain(CreateUsuarioInput input) {
        return new Usuario.UsuarioBuilder()
                .withNome(input.nome)
                .withUsername(input.username)
                .withSenha(input.senha)
                .withDataNascimento(input.dataNascimento)
                .withCPF(input.CPF)
                .withEmail(input.email)
                .withTell(input.tell)
                .withUserType(input.tipo)
                .build();
    }

    public static CreateUsuarioInput fromDomain (Usuario usuario) {
        return new CreateUsuarioInput(
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
