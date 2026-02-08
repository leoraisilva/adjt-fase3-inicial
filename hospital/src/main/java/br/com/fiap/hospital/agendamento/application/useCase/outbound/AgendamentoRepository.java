package br.com.fiap.hospital.agendamento.application.useCase.outbound;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta.BuscarConsultaOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.cancelar.CancelarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.verificar.VerificarOutput;

import java.util.List;

public interface AgendamentoRepository {
    Agendamento create (Agendamento agendamento);
    Agendamento findById (String idAgendamento);
    Agendamento delete (String idAgendamento);
    Agendamento update (Agendamento agendamento);
    List<Agendamento> findAll ();
}
