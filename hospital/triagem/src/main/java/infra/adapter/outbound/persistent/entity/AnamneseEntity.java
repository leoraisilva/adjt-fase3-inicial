package infra.adapter.outbound.persistent.entity;

import application.domain.Intensidade;
import jakarta.persistence.*;

@Entity
@Table(name = "anamnese_tb")
public class AnamneseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idAnamnese;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "dores")
    private String dores;
    @Column(name = "diabete")
    private boolean diabete;
    @Column(name = "pressaoAlta")
    private boolean pressaoAlta;
    @Column(name = "coracao")
    private boolean coracao;
    @Column(name = "historicoFamilia")
    private String historicoFamilia;
    @Column(name = "membroFamilia")
    private String membroFamilia;

    public AnamneseEntity(String descricao, String dores, boolean diabete, boolean pressaoAlta, boolean coracao, String historicoFamilia, String membroFamilia) {
        this.descricao = descricao;
        this.dores = dores;
        this.diabete = diabete;
        this.pressaoAlta = pressaoAlta;
        this.coracao = coracao;
        this.historicoFamilia = historicoFamilia;
        this.membroFamilia = membroFamilia;
    }

    public AnamneseEntity() { }

    public String getIdAnamnese() {
        return idAnamnese;
    }

    public void setIdAnamnese(String idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDores() {
        return dores;
    }

    public void setDores(String dores) {
        this.dores = dores;
    }

    public boolean isDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean isPressaoAlta() {
        return pressaoAlta;
    }

    public void setPressaoAlta(boolean pressaoAlta) {
        this.pressaoAlta = pressaoAlta;
    }

    public boolean isCoracao() {
        return coracao;
    }

    public void setCoracao(boolean coracao) {
        this.coracao = coracao;
    }

    public String getHistoricoFamilia() {
        return historicoFamilia;
    }

    public void setHistoricoFamilia(String historicoFamilia) {
        this.historicoFamilia = historicoFamilia;
    }

    public String getMembroFamilia() {
        return membroFamilia;
    }

    public void setMembroFamilia(String membroFamilia) {
        this.membroFamilia = membroFamilia;
    }
}
