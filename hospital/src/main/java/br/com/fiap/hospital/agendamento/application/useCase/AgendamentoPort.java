package br.com.fiap.hospital.agendamento.application.useCase;

import br.com.fiap.hospital.agendamento.application.useCase.agendar.AgendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.agendar.AgendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.buscarConsulta.BuscarConsultaOutput;
import br.com.fiap.hospital.agendamento.application.useCase.cancelar.CancelarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.reagendar.ReagendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.reagendar.ReagendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.verificar.VerificarOutput;

import java.util.List;

public interface AgendamentoPort {
    AgendarOutput agendar (AgendarInput input);
    BuscarConsultaOutput buscarConsulta (String idAgendamento);
    CancelarOutput cancelar (String idAgendamento);
    ReagendarOutput reagendar (ReagendarInput input);
    List<VerificarOutput> verificar ();
}
