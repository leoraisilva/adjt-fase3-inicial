package br.com.fiap.hospital.triagem.application.domain;

public class DefaultAnamneseFactory implements AnamneseFactory{
    @Override
    public Anamnese newAnamnese(String descricao, Intensidade dores, boolean diabete, boolean pressaoAlta, boolean coracao, String historicoFamilia, String membroFamilia) {
        return new Anamnese.AnamneseBuilder()
                .withDescricao(descricao)
                .withDores(dores)
                .withDiabete(diabete)
                .withPressaoAlta(pressaoAlta)
                .withCoracao(coracao)
                .withHistoricoFamilia(historicoFamilia)
                .withMembroFamilia(membroFamilia)
                .build();
    }
}
