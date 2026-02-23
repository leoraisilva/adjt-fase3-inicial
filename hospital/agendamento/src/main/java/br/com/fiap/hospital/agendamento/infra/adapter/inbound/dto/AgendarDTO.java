package br.com.fiap.hospital.agendamento.infra.adapter.inbound.dto;

import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;

public record AgendarDTO (String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel) {
}
