package br.com.fiap.hospital.agendamento.application.useCase.buscarConsulta;

import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;

import java.time.LocalDateTime;

public record BuscarConsultaOutput(String idAgendamento, String paciente, ConsultaType consulta, String responsavel, LocalDateTime dataConsulta, boolean reagendavel) {
}
