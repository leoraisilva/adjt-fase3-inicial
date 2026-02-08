package br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity.AgendamentoEntity;

public interface IAgendamentoMapper {
    Agendamento toDomain (AgendamentoEntity entity);
    AgendamentoEntity toEntity (Agendamento agendamento);
}
