package br.com.fiap.hospital.agendamento.application.service;

import br.com.fiap.hospital.agendamento.application.useCase.inbound.AgendamentoPort;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta.BuscarConsultaOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.cancelar.CancelarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.verificar.VerificarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.outbound.AgendamentoRepository;

import java.util.List;

public class AgendamentoService implements AgendamentoPort {
    private final AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgendarOutput agendar(AgendarInput input) {
        return AgendarOutput.fromDomain(repository.create(AgendarInput.toDomain(input)));
    }

    @Override
    public BuscarConsultaOutput buscarConsulta(String idAgendamento) {
        return BuscarConsultaOutput.fromDomain(repository.findById(idAgendamento));
    }

    @Override
    public CancelarOutput cancelar(String idAgendamento) {
        return CancelarOutput.fromDomain(repository.delete(idAgendamento));
    }

    @Override
    public ReagendarOutput reagendar(ReagendarInput input) {
        return ReagendarOutput.fromDomain(repository.update(ReagendarInput.toDomain(input)));
    }

    @Override
    public List<VerificarOutput> verificar() {
        return repository.findAll().stream()
                .map(VerificarOutput::fromDomain)
                .toList();
    }
}
