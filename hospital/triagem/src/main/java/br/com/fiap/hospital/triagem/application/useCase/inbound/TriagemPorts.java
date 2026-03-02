package br.com.fiap.hospital.triagem.application.useCase.inbound;

import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.consultarTriagem.ConsultarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagemInput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagemOutput;

public interface TriagemPorts {
    AlterarTriagemOutput alterarTriagem (AlterarTriagemInput input);
    GerarTriagemOutput gerarTriagem (GerarTriagemInput input);
    ConsultarTriagemOutput consultarTriagem (String paciente);
}
