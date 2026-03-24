package br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar;

import br.com.fiap.hospital.agendamento.application.useCase.inbound.AgendamentoPort;

public class Reagendar {
    private final AgendamentoPort agendamentoPort;
    public Reagendar (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public ReagendarOutput reagendar (ReagendarInput input) {
        return agendamentoPort.reagendar(input);
    }
}
