package br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.AgendamentoFactory;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity.AgendamentoEntity;

public class AgendamentoMapper implements IAgendamentoMapper{

    private final AgendamentoFactory factory;

    public AgendamentoMapper(AgendamentoFactory factory) {
        this.factory = factory;
    }

    @Override
    public Agendamento toDomain(AgendamentoEntity entity) {
        return factory.newAgendamento(
                entity.getIdAgendamento(),
                entity.getPaciente(),
                entity.getConsulta(),
                entity.getResponsavel(),
                entity.getDataConsulta(),
                entity.isReagendavel(),
                entity.isTriagem()
        );
    }

    @Override
    public AgendamentoEntity toEntity(Agendamento agendamento) {
        return new AgendamentoEntity(
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
