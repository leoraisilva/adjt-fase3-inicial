package application.useCase.alterarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;

public record AlterarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
