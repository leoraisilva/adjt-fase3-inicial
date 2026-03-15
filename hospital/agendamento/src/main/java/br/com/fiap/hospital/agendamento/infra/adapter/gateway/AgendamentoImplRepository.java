package br.com.fiap.hospital.agendamento.infra.adapter.gateway;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.AgendamentoFactory;
import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;
import br.com.fiap.hospital.agendamento.application.useCase.outbound.AgendamentoRepository;
import br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper.IAgendamentoMapper;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity.AgendamentoEntity;
import br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.repository.AgendamentoJPARepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoImplRepository implements AgendamentoRepository {
    private final AgendamentoJPARepository jpaRepository;
    private final IAgendamentoMapper mapper;
    private final AgendamentoFactory factory;

    public AgendamentoImplRepository(AgendamentoJPARepository jpaRepository, IAgendamentoMapper mapper, AgendamentoFactory factory) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
        this.factory = factory;
    }

    @Override
    public Agendamento create(Agendamento agendamento) {
        return mapper.toDomain(jpaRepository.save(mapper.toEntity(agendamento)));
    }

    @Override
    public Agendamento findById(String idAgendamento) {
        var optionalAgendamento = jpaRepository.findById(idAgendamento).orElseThrow(() -> new RuntimeException("Agendamento não localizado"));
        return mapper.toDomain(optionalAgendamento);
    }

    @Override
    public Agendamento delete(String idAgendamento) {
        var optionalAgendamento = jpaRepository.findById(idAgendamento).orElseThrow(() -> new RuntimeException("Agendamento não localizado"));
        optionalAgendamento.setConsulta(ConsultaType.CANCELADO);
        return mapper.toDomain(jpaRepository.save(optionalAgendamento));
    }

    @Override
    public Agendamento update(Agendamento agendamento) {
        var optionalAgendamento = jpaRepository.findById(agendamento.getIdAgendamento()).orElseGet(AgendamentoEntity::new);
        optionalAgendamento.setConsulta(agendamento.getConsulta());
        optionalAgendamento.setPaciente(agendamento.getPaciente());
        optionalAgendamento.setReagendavel(agendamento.isReagendavel());
        optionalAgendamento.setResponsavel(agendamento.getResponsavel());
        optionalAgendamento.setTriagem(agendamento.isTriagem());
        optionalAgendamento.setDataConsulta(agendamento .getDataConsulta());
        return mapper.toDomain(jpaRepository.save(optionalAgendamento));
    }

    @Override
    public List<Agendamento> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }
}
