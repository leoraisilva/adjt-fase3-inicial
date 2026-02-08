package br.com.fiap.hospital.agendamento.application.useCase.inbound.cancelar;

import br.com.fiap.hospital.agendamento.application.useCase.inbound.AgendamentoPort;

public class Cancelar {
    private final AgendamentoPort agendamentoPort;
    public Cancelar (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public CancelarOutput cancelar(String idAgendamento) {
        return agendamentoPort.cancelar(idAgendamento);
    }
}
