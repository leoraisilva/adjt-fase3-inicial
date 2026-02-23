package application.useCase.acessar;

import application.useCase.HistoricoPorts;

public class AcessarHistorico {
    public final HistoricoPorts historicoPorts;

    public AcessarHistorico (HistoricoPorts historicoPorts) {
        this.historicoPorts = historicoPorts;
    }

    public AcessarHistoricoOutput acessarHistorico (String paciente) {
        return historicoPorts.acessarHistorico(paciente);
    }
}
