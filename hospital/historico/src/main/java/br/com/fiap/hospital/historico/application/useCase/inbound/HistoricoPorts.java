package br.com.fiap.hospital.historico.application.useCase.inbound;


import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistoricoOutput;

import java.util.List;

public interface HistoricoPorts {
    List<AcessarHistoricoOutput> acessarHistorico (String paciente);
}
