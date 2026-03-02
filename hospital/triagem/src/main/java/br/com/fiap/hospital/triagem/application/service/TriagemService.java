package br.com.fiap.hospital.triagem.application.service;

import br.com.fiap.hospital.triagem.application.useCase.inbound.TriagemPorts;
import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.consultarTriagem.ConsultarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.outbound.TriagemRepository;

public class TriagemService implements TriagemPorts {
    private final TriagemRepository repository;

    public TriagemService(TriagemRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlterarTriagemOutput alterarTriagem(AlterarTriagemInput input) {
        return AlterarTriagemOutput.toOutput(repository.alterarTriagem(AlterarTriagemInput.toDomain(input)));
    }

    @Override
    public GerarTriagemOutput gerarTriagem(GerarTriagemInput input) {
        return GerarTriagemOutput.toOutput(repository.gerarTriagem(GerarTriagemInput.toDomain(input)));
    }

    @Override
    public ConsultarTriagemOutput consultarTriagem(String paciente) {
        return ConsultarTriagemOutput.toOutput(repository.consultarTriagem(paciente));
    }
}
