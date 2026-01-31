package br.com.fiap.hospital.agendamento.application.service;

import br.com.fiap.hospital.agendamento.application.useCase.AgendamentoPort;
import br.com.fiap.hospital.agendamento.application.useCase.agendar.AgendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.agendar.AgendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.buscarConsulta.BuscarConsultaOutput;
import br.com.fiap.hospital.agendamento.application.useCase.cancelar.CancelarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.reagendar.ReagendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.reagendar.ReagendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.verificar.VerificarOutput;

import java.util.List;

public class AgendamentoService implements AgendamentoPort {
    @Override
    public AgendarOutput agendar(AgendarInput input) {
        return null;
    }

    @Override
    public BuscarConsultaOutput buscarConsulta(String idAgendamento) {
        return null;
    }

    @Override
    public CancelarOutput cancelar(String idAgendamento) {
        return null;
    }

    @Override
    public ReagendarOutput reagendar(ReagendarInput input) {
        return null;
    }

    @Override
    public List<VerificarOutput> verificar() {
        return null;
    }
}
