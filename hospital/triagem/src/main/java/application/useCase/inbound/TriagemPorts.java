package application.useCase.inbound;

import application.useCase.inbound.alterarTriagem.AlterarTriagemInput;
import application.useCase.inbound.alterarTriagem.AlterarTriagemOutput;
import application.useCase.inbound.consultarTriagem.ConsultarTriagemOutput;
import application.useCase.inbound.gerarTriagem.GerarTriagemInput;
import application.useCase.inbound.gerarTriagem.GerarTriagemOutput;

public interface TriagemPorts {
    AlterarTriagemOutput alterarTriagem (AlterarTriagemInput input);
    GerarTriagemOutput gerarTriagem (GerarTriagemInput input);
    ConsultarTriagemOutput consultarTriagem (String paciente);
}
