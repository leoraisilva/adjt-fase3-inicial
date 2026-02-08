package br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario;

import br.com.fiap.hospital.usuario.application.domain.UserType;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.time.LocalDate;

public record UpdateUsuarioInput(String nome, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo) {
    public static Usuario toDomain(UpdateUsuarioInput output) {
        return new Usuario.UsuarioBuilder()
                .withNome(output.nome)
                .withSenha(output.senha)
                .withDataNascimento(output.dataNascimento)
                .withCPF(output.CPF)
                .withEmail(output.email)
                .withTell(output.tell)
                .withUserType(output.tipo)
                .build();
    }

    public static UpdateUsuarioInput fromDomain (Usuario usuario) {
        return new UpdateUsuarioInput(
                usuario.getNome(),
                usuario.getSenha(),
                usuario.getDataNascimento(),
                usuario.getCPF(),
                usuario.getEmail(),
                usuario.getTell(),
                usuario.getTipo()
        );
    }
}
