package br.com.fiap.hospital.historico.infra.adapter.inbound.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping(typeName = "inputAvaliacao")
public record InputAvaliacaoDTO (String pressao, String oxigenacao, String quadroClinico, String risco)  {
}
