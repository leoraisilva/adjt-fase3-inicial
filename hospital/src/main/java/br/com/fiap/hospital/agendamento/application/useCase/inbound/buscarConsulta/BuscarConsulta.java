package br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta;

import br.com.fiap.hospital.agendamento.application.useCase.inbound.AgendamentoPort;

public class BuscarConsulta {
    private final AgendamentoPort agendamentoPort;
    public BuscarConsulta (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public BuscarConsultaOutput buscarConsulta (String idAgendamento) {
        return agendamentoPort.buscarConsulta(idAgendamento);
    }
}
