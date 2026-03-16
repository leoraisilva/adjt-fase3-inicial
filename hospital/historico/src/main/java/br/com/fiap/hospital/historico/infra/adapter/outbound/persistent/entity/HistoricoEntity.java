package br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.entity;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historico")
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String historicoId;
    @Column(name = "paciente")
    private String  paciente;
    @Column(name = "consulta")
    private String consulta_id;
    @Column(name = "mensagem_id")
    private String  mensagem;
    @Column(name = "triagem_id")
    private String  triagem;
    @Column(name = "data_registro")
    private String dataRegistro;
    @Column(name = "resultado")
    private String resultado;

    public HistoricoEntity(String  paciente, String consulta_id, String mensagem, String triagem, String dataRegistro, String resultado) {
        this.paciente = paciente;
        this.consulta_id = consulta_id;
        this.mensagem = mensagem;
        this.triagem = triagem;
        this.dataRegistro = dataRegistro;
        this.resultado = resultado;
    }

    public HistoricoEntity(){}

    public String getHistoricoId() {
        return historicoId;
    }

    public void setHistoricoId(String historicoId) {
        this.historicoId = historicoId;
    }

    public String  getPaciente() {
        return paciente;
    }

    public void setPaciente(String  paciente) {
        this.paciente = paciente;
    }

    public String getConsulta_id() {
        return consulta_id;
    }

    public void setConsulta_id(String consulta_id) {
        this.consulta_id = consulta_id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTriagem() {
        return triagem;
    }

    public void setTriagem(String triagem) {
        this.triagem = triagem;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
