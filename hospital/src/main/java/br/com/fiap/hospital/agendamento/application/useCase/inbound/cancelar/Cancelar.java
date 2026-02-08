package br.com.fiap.hospital.agendamento.application.useCase.cancelar;

import br.com.fiap.hospital.agendamento.application.useCase.AgendamentoPort;

public class Cancelar {
    private final AgendamentoPort agendamentoPort;
    public Cancelar (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public CancelarOutput cancelar(String idAgendamento) {
        return agendamentoPort.cancelar(idAgendamento);
    }
}
