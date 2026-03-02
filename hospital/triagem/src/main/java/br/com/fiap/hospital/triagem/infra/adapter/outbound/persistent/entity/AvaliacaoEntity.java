package br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Avaliacao_tb")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idAvaliacao;
    @Column(name = "pressao_paciente")
    private  String pressao;
    @Column(name = "oxigenacao_paciente")
    private String oxigenacao;
    @Column(name = "quadroClinico_paciente")
    private String quadroClinico;
    @Column(name = "risco")
    private String risco;

    public AvaliacaoEntity(String pressao, String oxigenacao, String quadroClinico, String risco) {
        this.pressao = pressao;
        this.oxigenacao = oxigenacao;
        this.quadroClinico = quadroClinico;
        this.risco = risco;
    }

    public AvaliacaoEntity() { }

    public String getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(String idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getOxigenacao() {
        return oxigenacao;
    }

    public void setOxigenacao(String oxigenacao) {
        this.oxigenacao = oxigenacao;
    }

    public String getQuadroClinico() {
        return quadroClinico;
    }

    public void setQuadroClinico(String quadroClinico) {
        this.quadroClinico = quadroClinico;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }
}
