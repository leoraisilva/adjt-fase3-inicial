package br.com.fiap.hospital.historico.application.useCase.outbound;

import br.com.fiap.hospital.historico.application.domain.Historico;

import java.util.List;

public interface HistoricoRepository {
    List<Historico> acessarHistorico (String paciente);
    Historico registrarHistorico (Historico historico);
}
