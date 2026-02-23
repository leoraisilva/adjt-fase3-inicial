package application.domain;

public interface AnamneseFactory {
    Anamnese newAnamnese (String descricao, Intensidade dores, boolean diabete, boolean pressaoAlta, boolean coracao, String historicoFamilia, String membroFamilia);
}
