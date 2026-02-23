package application.useCase;

import application.useCase.alterarTriagem.AlterarTriagemInput;
import application.useCase.alterarTriagem.AlterarTriagemOutput;
import application.useCase.consultarTriagem.ConsultarTriagemOutput;
import application.useCase.gerarTriagem.GerarTriagemInput;
import application.useCase.gerarTriagem.GerarTriagemOutput;

public interface TriagemPorts {
    AlterarTriagemOutput alterarTriagem (AlterarTriagemInput input);
    GerarTriagemOutput gerarTriagem (GerarTriagemInput input);
    ConsultarTriagemOutput consultarTriagem (String paciente);
}
