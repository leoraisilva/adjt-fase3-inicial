package application.domain;

public class DefaultAvaliacaoFactory implements AvaliacaoFactory{
    @Override
    public Avaliacao newAvaliacao(String idAvaliacao, String pressao, String oxigenacao, String quadroClinico, Classificacao risco) {
        return new Avaliacao.AvaliacaoBuilder()
                .withIdAvaliacao(idAvaliacao)
                .withPressao(pressao)
                .withOxigenacao(oxigenacao)
                .withQuadroClinico(quadroClinico)
                .withRisco(risco)
                .build();
    }
}
