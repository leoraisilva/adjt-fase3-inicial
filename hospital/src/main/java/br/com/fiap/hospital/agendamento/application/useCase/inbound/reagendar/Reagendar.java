package br.com.fiap.hospital.agendamento.application.useCase.reagendar;

import br.com.fiap.hospital.agendamento.application.useCase.AgendamentoPort;

public class Reagendar {
    private final AgendamentoPort agendamentoPort;
    public Reagendar (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public ReagendarOutput reagendar (ReagendarInput input) {
        return agendamentoPort.reagendar(input);
    }
}
