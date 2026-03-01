package application.domain;

public interface AvaliacaoFactory {
    Avaliacao newAvaliacao (String idAvaliacao, String pressao, String oxigenacao, String quadroClinico, Classificacao risco);
}
