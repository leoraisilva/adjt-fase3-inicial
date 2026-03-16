package br.com.fiap.hospital.mensageria.event;

public record AgendamentoDTO(String idAgendamento, String paciente, String consulta, String responsavel, String dataConsulta, boolean reagendavel) {
}
