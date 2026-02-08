package br.com.fiap.hospital.agendamento.application.useCase.buscarConsulta;

import br.com.fiap.hospital.agendamento.application.useCase.AgendamentoPort;

public class BuscarConsulta {
    private final AgendamentoPort agendamentoPort;
    public BuscarConsulta (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public BuscarConsultaOutput buscarConsulta (String idAgendamento) {
        return agendamentoPort.buscarConsulta(idAgendamento);
    }
}
