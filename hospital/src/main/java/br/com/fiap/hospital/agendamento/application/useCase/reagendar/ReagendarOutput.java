package br.com.fiap.hospital.agendamento.application.useCase.reagendar;

import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;

import java.time.LocalDateTime;

public record ReagendarOutput (String idAgendamento, String paciente, ConsultaType consulta, String responsavel, LocalDateTime dataConsulta, boolean reagendavel){
}
