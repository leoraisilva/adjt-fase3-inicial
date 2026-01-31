package br.com.fiap.hospital.usuario.application.useCase.createUsuario;

import br.com.fiap.hospital.usuario.application.domain.UserType;

import java.time.LocalDate;

public record CreateUsuarioInput(String nome, String username, String senha, LocalDate dataNascimento, UserType tipo) {
}
