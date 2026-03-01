package application.service;

import application.useCase.inbound.TriagemPorts;
import application.useCase.inbound.alterarTriagem.AlterarTriagemInput;
import application.useCase.inbound.alterarTriagem.AlterarTriagemOutput;
import application.useCase.inbound.consultarTriagem.ConsultarTriagemOutput;
import application.useCase.inbound.gerarTriagem.GerarTriagemInput;
import application.useCase.inbound.gerarTriagem.GerarTriagemOutput;
import application.useCase.outbound.TriagemRepository;

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
