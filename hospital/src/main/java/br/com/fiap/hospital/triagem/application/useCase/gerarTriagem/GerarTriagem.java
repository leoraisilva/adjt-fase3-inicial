package br.com.fiap.hospital.triagem.application.useCase.gerarTriagem;

import br.com.fiap.hospital.triagem.application.useCase.TriagemPorts;

public class GerarTriagem {
    public final TriagemPorts triagemPorts;

    public GerarTriagem (TriagemPorts triagemPorts) {
        this.triagemPorts = triagemPorts;
    }

    public GerarTriagemOutput gerarTriagem (GerarTriagemInput input) {
        return triagemPorts.gerarTriagem(input);
    }
}
