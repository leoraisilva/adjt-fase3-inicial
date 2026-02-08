package br.com.fiap.hospital.triagem.application.useCase.consultarTriagem;

import br.com.fiap.hospital.triagem.application.useCase.TriagemPorts;

public class ConsultarTriagem {
    public final TriagemPorts triagemPorts;

    public ConsultarTriagem (TriagemPorts triagemPorts) {
        this.triagemPorts = triagemPorts;
    }

    public ConsultarTriagemOutput consultarTriagem (String paciente) {
        return triagemPorts.consultarTriagem(paciente);
    }
}
