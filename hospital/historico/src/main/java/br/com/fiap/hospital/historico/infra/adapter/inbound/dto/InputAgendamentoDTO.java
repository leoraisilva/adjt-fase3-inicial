package br.com.fiap.hospital.historico.infra.adapter.inbound.dto;

import org.springframework.graphql.data.method.annotation.SchemaMapping;

@SchemaMapping(typeName = "inputAgendamento")
public record InputAgendamentoDTO (String idAgendamento, String paciente, String consulta, String responsavel, String dataConsulta, boolean reagendavel) {

}
