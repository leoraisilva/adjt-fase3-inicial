package application.domain;

public interface AvaliacaoFactory {
    Avaliacao newAvaliacao (String pressao, String oxigenacao, String quadroClinico, Classificacao risco);
}
