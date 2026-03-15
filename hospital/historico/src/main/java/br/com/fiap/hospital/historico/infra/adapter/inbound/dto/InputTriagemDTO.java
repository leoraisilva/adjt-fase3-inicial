package br.com.fiap.hospital.historico.infra.adapter.inbound.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping(typeName = "inputNotificacao")
public record InputTriagemDTO (String paciente, String responsavel, InputAnamneseDTO anamnese, InputAvaliacaoDTO avaliacao) {
}
