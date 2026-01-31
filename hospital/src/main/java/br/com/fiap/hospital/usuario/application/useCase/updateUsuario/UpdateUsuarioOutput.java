package br.com.fiap.hospital.usuario.application.useCase.updateUsuario;

import br.com.fiap.hospital.usuario.application.domain.UserType;

import java.time.LocalDate;

public record UpdateUsuarioOutput(String nome, String username, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo) {
}
