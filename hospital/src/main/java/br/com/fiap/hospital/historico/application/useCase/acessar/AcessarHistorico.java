package br.com.fiap.hospital.historico.application.useCase.acessar;

import br.com.fiap.hospital.historico.application.useCase.HistoricoPorts;

public class AcessarHistorico {
    public final HistoricoPorts historicoPorts;

    public AcessarHistorico (HistoricoPorts historicoPorts) {
        this.historicoPorts = historicoPorts;
    }

    public AcessarHistoricoOutput acessarHistorico (String paciente) {
        return historicoPorts.acessarHistorico(paciente);
    }
}
