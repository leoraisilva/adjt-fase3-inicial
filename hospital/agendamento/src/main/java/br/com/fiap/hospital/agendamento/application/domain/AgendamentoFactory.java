package br.com.fiap.hospital.agendamento.application.domain;

public interface AgendamentoFactory {
    Agendamento newAgendamento(String idAgendamento, String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel, boolean triagem);
}