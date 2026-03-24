package br.com.fiap.hospital.agendamento.application.useCase.outbound;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;

import java.util.List;

public interface AgendamentoRepository {
    Agendamento create (Agendamento agendamento);
    Agendamento findById (String idAgendamento);
    Agendamento delete (String idAgendamento);
    Agendamento update (Agendamento agendamento);
    List<Agendamento> findAll ();
}
