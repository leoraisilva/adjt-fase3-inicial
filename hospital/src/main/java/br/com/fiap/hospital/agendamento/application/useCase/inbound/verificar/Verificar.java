package br.com.fiap.hospital.agendamento.application.useCase.verificar;

import br.com.fiap.hospital.agendamento.application.useCase.AgendamentoPort;

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
