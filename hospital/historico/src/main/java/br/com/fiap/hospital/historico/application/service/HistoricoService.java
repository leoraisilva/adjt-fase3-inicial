package br.com.fiap.hospital.historico.application.service;

import br.com.fiap.hospital.historico.application.useCase.inbound.HistoricoPorts;
import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistoricoOutput;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistoricoInput;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistoricoOutput;
import br.com.fiap.hospital.historico.application.useCase.outbound.HistoricoRepository;

import java.util.List;

public class HistoricoService implements HistoricoPorts {
    private final HistoricoRepository repository;

    public HistoricoService(HistoricoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AcessarHistoricoOutput> acessarHistorico(String paciente) {
        return repository.acessarHistorico(paciente).stream()
                .map(AcessarHistoricoOutput::toOutput)
                .toList();
    }

    @Override
    public RegistrarHistoricoOutput registrarHistorico(RegistrarHistoricoInput input) {
        return RegistrarHistoricoOutput.toOutput(repository.registrarHistorico(RegistrarHistoricoInput.toDomain(input)));
    }
}
