package application.useCase.inbound.consultarTriagem;

import application.useCase.inbound.TriagemPorts;

public class ConsultarTriagem {
    public final TriagemPorts triagemPorts;

    public ConsultarTriagem (TriagemPorts triagemPorts) {
        this.triagemPorts = triagemPorts;
    }

    public ConsultarTriagemOutput consultarTriagem (String paciente) {
        return triagemPorts.consultarTriagem(paciente);
    }
}
