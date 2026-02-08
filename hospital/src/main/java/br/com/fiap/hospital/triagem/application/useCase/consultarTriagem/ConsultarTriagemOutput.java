package br.com.fiap.hospital.triagem.application.useCase.consultarTriagem;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.application.domain.Avaliacao;

public record ConsultarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
