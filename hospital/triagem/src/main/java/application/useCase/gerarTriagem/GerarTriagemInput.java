package application.useCase.gerarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;

public record GerarTriagemInput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
