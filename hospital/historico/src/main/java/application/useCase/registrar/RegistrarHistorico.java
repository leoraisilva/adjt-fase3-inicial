package application.useCase.registrar;

import application.useCase.HistoricoPorts;

public class RegistrarHistorico {
    public final HistoricoPorts historicoPorts;

    public RegistrarHistorico (HistoricoPorts historicoPorts) {
        this.historicoPorts = historicoPorts;
    }

    public RegistrarHistoricoOutput registrarHistorico (RegistrarHistoricoInput input) {
        return  historicoPorts.registrarHistorico(input);
    }
}
