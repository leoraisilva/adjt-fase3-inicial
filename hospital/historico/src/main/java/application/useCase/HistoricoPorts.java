package application.useCase;

import br.com.fiap.hospital.historico.application.useCase.acessar.AcessarHistoricoOutput;
import br.com.fiap.hospital.historico.application.useCase.registrar.RegistrarHistoricoInput;
import br.com.fiap.hospital.historico.application.useCase.registrar.RegistrarHistoricoOutput;

public interface HistoricoPorts {
    AcessarHistoricoOutput acessarHistorico (String paciente);
    RegistrarHistoricoOutput registrarHistorico (RegistrarHistoricoInput input);
}
