package br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.entity;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "historico_tb")
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idHistorico;
    @Column(name = "paciente")
    private String  paciente;
    @Column(name = "consulta_id")
    private String consulta;
    @Column(name = "mensagem_id")
    private String  mensagem;
    @Column(name = "triagem_id")
    private String  triagem;
    @Column(name = "data_registro")
    private String dataRegistro;
    @Column(name = "resultado")
    private String resultado;

    public HistoricoEntity(String  paciente, String consulta, String mensagem, String triagem, String dataRegistro, String resultado) {
        this.paciente = paciente;
        this.consulta = consulta;
        this.mensagem = mensagem;
        this.triagem = triagem;
        this.dataRegistro = dataRegistro;
        this.resultado = resultado;
    }

    public HistoricoEntity(){}

    public String getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(String idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String  getPaciente() {
        return paciente;
    }

    public void setPaciente(String  paciente) {
        this.paciente = paciente;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
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
