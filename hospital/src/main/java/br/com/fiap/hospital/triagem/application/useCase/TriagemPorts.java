package br.com.fiap.hospital.triagem.application.useCase;

import br.com.fiap.hospital.triagem.application.useCase.alterarTriagem.AlterarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.alterarTriagem.AlterarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.consultarTriagem.ConsultarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.gerarTriagem.GerarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.gerarTriagem.GerarTriagemOutput;

public interface TriagemPorts {
    AlterarTriagemOutput alterarTriagem (AlterarTriagemInput input);
    GerarTriagemOutput gerarTriagem (GerarTriagemInput input);
    ConsultarTriagemOutput consultarTriagem (String paciente);
}
