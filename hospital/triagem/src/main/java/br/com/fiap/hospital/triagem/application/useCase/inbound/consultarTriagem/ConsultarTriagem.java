package br.com.fiap.hospital.triagem.application.useCase.inbound.consultarTriagem;

import br.com.fiap.hospital.triagem.application.useCase.inbound.TriagemPorts;

public class ConsultarTriagem {
    public final TriagemPorts triagemPorts;

    public ConsultarTriagem (TriagemPorts triagemPorts) {
        this.triagemPorts = triagemPorts;
    }

    public ConsultarTriagemOutput consultarTriagem (String idTriagem) {
        return triagemPorts.consultarTriagem(idTriagem);
    }
}
