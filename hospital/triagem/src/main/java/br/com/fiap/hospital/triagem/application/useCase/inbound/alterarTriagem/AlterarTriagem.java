package br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem;

import br.com.fiap.hospital.triagem.application.useCase.inbound.TriagemPorts;

public class AlterarTriagem {
    public final TriagemPorts triagemPorts;

    public AlterarTriagem (TriagemPorts triagemPorts) {
        this.triagemPorts = triagemPorts;
    }

    public AlterarTriagemOutput alterarTriagem (AlterarTriagemInput input) {
        return triagemPorts.alterarTriagem(input);
    }
}
