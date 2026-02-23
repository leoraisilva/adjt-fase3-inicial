package application.useCase.alterarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;

public record AlterarTriagemInput(String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
