package br.com.fiap.hospital.usuario.infra.adapter.inbound.dto;

import br.com.fiap.hospital.usuario.application.domain.UserType;

import java.time.LocalDate;

public record UsuarioUpdateDTO(String nome, String username, String senha, LocalDate dataNascimento, UserType tipo, String CPF, String email, String tell) {
}
