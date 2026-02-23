package application.useCase.gerarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;

public record GerarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
