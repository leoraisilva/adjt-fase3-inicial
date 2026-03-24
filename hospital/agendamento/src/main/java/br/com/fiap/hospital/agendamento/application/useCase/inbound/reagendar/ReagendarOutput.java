package br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;

public record ReagendarOutput (String idAgendamento, String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel, boolean triagem){
    public static Agendamento toDomain(ReagendarOutput output) {
        return new Agendamento.AgendamentoBuilder()
                .withId(output.idAgendamento())
                .withPaciente(output.paciente())
                .withConsulta(output.consulta())
                .withResponsavel(output.responsavel())
                .withDataConsulta(output.dataConsulta())
                .withReagendavel(output.reagendavel())
                .withTriagem(output.triagem())
                .build();
    }

    public static ReagendarOutput fromDomain (Agendamento agendamento) {
        return new ReagendarOutput(
                agendamento.getIdAgendamento(),
                agendamento.getPaciente(),
                agendamento.getConsulta(),
                agendamento.getResponsavel(),
                agendamento.getDataConsulta(),
                agendamento.isReagendavel(),
                agendamento.isTriagem()
        );
    }
}
