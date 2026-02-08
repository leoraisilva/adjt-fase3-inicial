package br.com.fiap.hospital.usuario.infra.adapter.inbound.dto;

import br.com.fiap.hospital.usuario.application.domain.UserType;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity.UsuarioEntity;

import java.time.LocalDate;

public record UsuarioCreateDTO(String nome, String username, String senha, LocalDate dataNascimento, UserType tipo, String CPF, String email, String tell) {

}
