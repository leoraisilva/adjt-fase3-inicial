package application.domain;

public interface AnamneseFactory {
    Anamnese newAnamnese (String idAnamnese, String descricao, Intensidade dores, boolean diabete, boolean pressaoAlta, boolean coracao, String historicoFamilia, String membroFamilia);
}
