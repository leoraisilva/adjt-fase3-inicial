package br.com.fiap.hospital.agendamento.application.useCase.inbound.verificar;

import br.com.fiap.hospital.agendamento.application.useCase.inbound.AgendamentoPort;

import java.util.List;

public class Verificar {
    private final AgendamentoPort agendamentoPort;
    public Verificar (AgendamentoPort agendamentoPort) {
        this.agendamentoPort = agendamentoPort;
    }

    public List<VerificarOutput> verificar () {
        return agendamentoPort.verificar();
    }
}
