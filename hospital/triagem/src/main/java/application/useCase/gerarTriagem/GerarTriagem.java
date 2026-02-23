package application.useCase.gerarTriagem;

import application.useCase.TriagemPorts;

public class GerarTriagem {
    public final TriagemPorts triagemPorts;

    public GerarTriagem (TriagemPorts triagemPorts) {
        this.triagemPorts = triagemPorts;
    }

    public GerarTriagemOutput gerarTriagem (GerarTriagemInput input) {
        return triagemPorts.gerarTriagem(input);
    }
}
