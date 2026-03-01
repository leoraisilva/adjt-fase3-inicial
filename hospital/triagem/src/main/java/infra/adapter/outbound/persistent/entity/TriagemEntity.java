package infra.adapter.outbound.persistent.entity;

import application.domain.Anamnese;
import application.domain.Avaliacao;
import jakarta.persistence.*;

@Entity
@Table(name = "triagem_tb")
public class TriagemEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String idTriagem;
    @Column(name = "paciente")
    private String paciente;
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "anamnese", unique = true)
    private String idAnamnese;
    @Column(name = "avaliacao", unique = true)
    private String  idAvaliacao;

    public TriagemEntity(String paciente, String responsavel, String idAnamnese, String idAvaliacao) {
        this.paciente = paciente;
        this.responsavel = responsavel;
        this.idAnamnese = idAnamnese;
        this.idAvaliacao = idAvaliacao;
    }

    public TriagemEntity () {}

    public String getIdTriagem() {
        return idTriagem;
    }

    public void setIdTriagem(String idTriagem) {
        this.idTriagem = idTriagem;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(String idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public String getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(String idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }
}
