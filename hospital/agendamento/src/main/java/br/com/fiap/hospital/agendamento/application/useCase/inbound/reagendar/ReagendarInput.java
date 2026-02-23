package br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;

public record ReagendarInput(String idAgendamento, String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel) {
    public static Agendamento toDomain(ReagendarInput input) {
        return new Agendamento.AgendamentoBuilder()
                .withId(input.idAgendamento())
                .withPaciente(input.paciente())
                .withConsulta(input.consulta())
                .withResponsavel(input.responsavel())
                .withDataConsulta(input.dataConsulta())
                .withReagendavel(input.reagendavel())
                .build();
    }

    public static ReagendarInput fromDomain (Agendamento agendamento) {
        return new ReagendarInput(
                agendamento.getIdAgendamento(),
                agendamento.getPaciente(),
                agendamento.getConsulta(),
                agendamento.getResponsavel(),
                agendamento.getDataConsulta(),
                agendamento.isReagendavel()
        );
    }
}
