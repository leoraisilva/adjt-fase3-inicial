package br.com.fiap.hospital.triagem.application.domain;

public class DefaultAvaliacaoFactory implements AvaliacaoFactory{
    @Override
    public Avaliacao newAvaliacao(String pressao, String oxigenacao, String quadroClinico, Classificacao risco) {
        return new Avaliacao.AvaliacaoBuilder()
                .withPressao(pressao)
                .withOxigenacao(oxigenacao)
                .withQuadroClinico(quadroClinico)
                .withRisco(risco)
                .build();
    }
}
