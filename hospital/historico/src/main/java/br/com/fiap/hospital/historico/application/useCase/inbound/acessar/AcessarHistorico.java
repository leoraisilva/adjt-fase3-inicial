package br.com.fiap.hospital.historico.application.useCase.inbound.acessar;

import br.com.fiap.hospital.historico.application.useCase.inbound.HistoricoPorts;

import java.util.List;

public class AcessarHistorico {
    public final HistoricoPorts historicoPorts;

    public AcessarHistorico (HistoricoPorts historicoPorts) {
        this.historicoPorts = historicoPorts;
    }

    public List<AcessarHistoricoOutput> acessarHistorico (String paciente) {
        return historicoPorts.acessarHistorico(paciente);
    }
}
