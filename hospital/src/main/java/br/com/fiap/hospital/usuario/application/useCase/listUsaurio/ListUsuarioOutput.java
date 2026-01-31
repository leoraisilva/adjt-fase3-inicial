package br.com.fiap.hospital.usuario.application.useCase.listUsaurio;

import br.com.fiap.hospital.usuario.application.domain.UserType;

import java.time.LocalDate;

public record ListUsuarioOutput(String nome, String username, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo) {
}
