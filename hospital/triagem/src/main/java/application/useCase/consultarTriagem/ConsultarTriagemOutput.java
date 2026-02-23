package application.useCase.consultarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;

public record ConsultarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
