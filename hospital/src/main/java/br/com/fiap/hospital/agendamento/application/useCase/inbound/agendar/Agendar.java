package br.com.fiap.hospital.agendamento.application.useCase.agendar;

import br.com.fiap.hospital.agendamento.application.useCase.AgendamentoPort;

public class Agendar {
    private final AgendamentoPort agendamentoPort;
    public Agendar (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public AgendarOutput agendar (AgendarInput input){
        return agendamentoPort.agendar(input);
    }
}
