package br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity;

import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamento_tb")
public class AgendamentoEntity {
    @Id
    private String idAgendamento;
    @Column(name = "paciente")
    private String paciente;
    @Column(name = "consulta")
    private ConsultaType consulta;
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "data_consulta")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String dataConsulta;
    @Column(name = "reagendavel")
    private boolean reagendavel;
    @Column(name = "triagem")
    private boolean triagem;

    public AgendamentoEntity(String idAgendamento, String paciente, ConsultaType consulta, String responsavel, String dataConsulta, boolean reagendavel, boolean triagem) {
        this.idAgendamento = idAgendamento;
        this.paciente = paciente;
        this.consulta = consulta;
        this.responsavel = responsavel;
        this.dataConsulta = dataConsulta;
        this.reagendavel = reagendavel;
        this.triagem = triagem;
    }

    public AgendamentoEntity() {}

    public String getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(String idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public ConsultaType getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaType consulta) {
        this.consulta = consulta;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public boolean isReagendavel() {
        return reagendavel;
    }

    public void setReagendavel(boolean reagendavel) {
        this.reagendavel = reagendavel;
    }

    public boolean isTriagem() {
        return triagem;
    }

    public void setTriagem(boolean triagem) {
        this.triagem = triagem;
    }
}
