package br.com.fiap.hospital.agendamento.application.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Agendamento {
    private String idAgendamento;
    private String paciente;
    private ConsultaType consulta;
    private String responsavel;
    private LocalDateTime dataConsulta;
    private boolean reagendavel;

    public Agendamento(AgendamentoBuilder builder) {
        this.idAgendamento = builder.idAgendamento;
        this.paciente = builder.paciente;
        this.consulta = builder.consulta;
        this.responsavel = builder.responsavel;
        this.dataConsulta = builder.dataConsulta;
        this.reagendavel = builder.reagendavel;
    }

    public String getIdAgendamento() {
        return idAgendamento;
    }

    public String getPaciente() {
        return paciente;
    }

    public ConsultaType getConsulta() {
        return consulta;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public boolean isReagendavel() {
        return reagendavel;
    }

    public static class AgendamentoBuilder {
        private String idAgendamento;
        private String paciente;
        private ConsultaType consulta;
        private String responsavel;
        private LocalDateTime dataConsulta;
        private boolean reagendavel;

        public AgendamentoBuilder withId (String idAgendamento) {
            this.idAgendamento = idAgendamento;
            return this;
        }

        public AgendamentoBuilder withPaciente (String paciente) {
            this.paciente = paciente;
            return this;
        }

        public AgendamentoBuilder withConsulta (ConsultaType consulta) {
            this.consulta = consulta;
            return this;
        }

        public AgendamentoBuilder withResponsavel (String responsavel) {
            this.responsavel = responsavel;
            return this;
        }

        public AgendamentoBuilder withDataConsulta (LocalDateTime dataConsulta) {
            this.dataConsulta = dataConsulta;
            return this;
        }

        public AgendamentoBuilder withReagendavel (boolean reagendavel) {
            this.reagendavel = reagendavel;
            return this;
        }

        public Agendamento build () {
            return new Agendamento(this);
        }

    }
}
