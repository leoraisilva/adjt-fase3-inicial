package application.service;

import application.useCase.TriagemPorts;
import application.useCase.alterarTriagem.AlterarTriagemInput;
import application.useCase.alterarTriagem.AlterarTriagemOutput;
import application.useCase.consultarTriagem.ConsultarTriagemOutput;
import application.useCase.gerarTriagem.GerarTriagemInput;
import application.useCase.gerarTriagem.GerarTriagemOutput;

public class TriagemService implements TriagemPorts {
    @Override
    public AlterarTriagemOutput alterarTriagem(AlterarTriagemInput input) {
        return null;
    }

    @Override
    public GerarTriagemOutput gerarTriagem(GerarTriagemInput input) {
        return null;
    }

    @Override
    public ConsultarTriagemOutput consultarTriagem(String paciente) {
        return null;
    }
}
