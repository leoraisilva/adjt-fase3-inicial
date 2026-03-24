package br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;

public record AgendarInput(String idAgendamento, String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel, boolean triagem) {
    public static Agendamento toDomain(AgendarInput input) {
        return new Agendamento.AgendamentoBuilder()
                .withId(input.idAgendamento())
                .withPaciente(input.paciente())
                .withConsulta(input.consulta())
                .withResponsavel(input.responsavel())
                .withDataConsulta(input.dataConsulta())
                .withReagendavel(input.reagendavel())
                .withTriagem(input.triagem())
                .build();
    }

    public static AgendarInput fromDomain (Agendamento agendamento) {
        return new AgendarInput(
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
