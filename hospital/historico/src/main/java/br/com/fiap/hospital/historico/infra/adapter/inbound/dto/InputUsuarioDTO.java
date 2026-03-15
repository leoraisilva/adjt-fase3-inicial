package br.com.fiap.hospital.historico.infra.adapter.inbound.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping(typeName = "inputUsuario")
public record InputUsuarioDTO (String idUsuario, String nome, String username, String senha, String dataNascimento, String tipo, String CPF, String email, String tell) {
}
