package br.com.fiap.hospital.historico.infra.adapter.inbound.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping(typeName = "inputNotificacao")
public record InputNotificacaoDTO (String idMensagem, String categoria, String titulo, String mensagem, String nome, String email, String tell) {
}
