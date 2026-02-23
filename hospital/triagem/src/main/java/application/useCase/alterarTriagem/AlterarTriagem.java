package application.useCase.alterarTriagem;

import application.useCase.TriagemPorts;

public class AlterarTriagem {
    public final TriagemPorts triagemPorts;

    public AlterarTriagem (TriagemPorts triagemPorts) {
        this.triagemPorts = triagemPorts;
    }

    public AlterarTriagemOutput alterarTriagem (AlterarTriagemInput input) {
        return triagemPorts.alterarTriagem(input);
    }
}
