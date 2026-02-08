package br.com.fiap.hospital.triagem.application.service;

import br.com.fiap.hospital.triagem.application.useCase.TriagemPorts;
import br.com.fiap.hospital.triagem.application.useCase.alterarTriagem.AlterarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.alterarTriagem.AlterarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.consultarTriagem.ConsultarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.gerarTriagem.GerarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.gerarTriagem.GerarTriagemOutput;

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
