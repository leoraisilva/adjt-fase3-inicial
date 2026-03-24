package br.com.fiap.hospital.agendamento.application.useCase.inbound;

import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta.BuscarConsultaOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.cancelar.CancelarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.verificar.VerificarOutput;

import java.util.List;

public interface AgendamentoPort {
    AgendarOutput agendar (AgendarInput input);
    BuscarConsultaOutput buscarConsulta (String idAgendamento);
    CancelarOutput cancelar (String idAgendamento);
    ReagendarOutput reagendar (ReagendarInput input);
    List<VerificarOutput> verificar ();
}
