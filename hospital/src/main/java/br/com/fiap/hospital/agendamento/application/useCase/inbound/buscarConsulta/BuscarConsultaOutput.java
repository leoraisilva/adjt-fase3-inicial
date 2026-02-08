package br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;

import java.time.LocalDateTime;

public record BuscarConsultaOutput(String idAgendamento, String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel) {
    public static Agendamento toDomain(BuscarConsultaOutput output) {
        return new Agendamento.AgendamentoBuilder()
                .withId(output.idAgendamento())
                .withPaciente(output.paciente())
                .withConsulta(output.consulta())
                .withResponsavel(output.responsavel())
                .withDataConsulta(output.dataConsulta())
                .withReagendavel(output.reagendavel())
                .build();
    }

    public static BuscarConsultaOutput fromDomain (Agendamento agendamento) {
        return new BuscarConsultaOutput(
                agendamento.getIdAgendamento(),
                agendamento.getPaciente(),
                agendamento.getConsulta(),
                agendamento.getResponsavel(),
                agendamento.getDataConsulta(),
                agendamento.isReagendavel()
        );
    }
}
