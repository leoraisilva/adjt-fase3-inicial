package br.com.fiap.hospital.historico.application.useCase.inbound;


import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistoricoOutput;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistoricoInput;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistoricoOutput;

import java.util.List;

public interface HistoricoPorts {
    List<AcessarHistoricoOutput> acessarHistorico (String paciente);
    RegistrarHistoricoOutput registrarHistorico (RegistrarHistoricoInput input);
}
