package br.com.fiap.hospital.historico.infra.adapter.inbound.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping(typeName = "inputAnamnese")
public record InputAnamneseDTO (String descricao, String dores, boolean diabete, boolean pressaoAlta, boolean coracao, String historicoFamilia, String membroFamilia) {
}
