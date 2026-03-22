package br.com.fiap.hospital.historico.application.useCase.outbound;

import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.mensageria.event.HistoricoDTO;

import java.util.List;

public interface HistoricoRepository {
    List<Historico> acessarHistorico (String paciente);
    void registrar (HistoricoDTO historico);
}
