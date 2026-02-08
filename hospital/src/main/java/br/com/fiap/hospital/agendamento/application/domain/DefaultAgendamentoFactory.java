package br.com.fiap.hospital.agendamento.application.domain;

import java.time.LocalDateTime;

public class DefaultAgendamentoFactory implements AgendamentoFactory{

    public DefaultAgendamentoFactory () {}
    @Override
    public Agendamento newAgendamento(String idAgendamento, String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel) {
        return new Agendamento.AgendamentoBuilder()
                .withId(idAgendamento)
                .withPaciente(paciente)
                .withConsulta(consulta)
                .withResponsavel(responsavel)
                .withDataConsulta(dataConsulta)
                .withReagendavel(reagendavel)
                .build();
    }
}
