package br.com.fiap.hospital.triagem.application.useCase.alterarTriagem;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.application.domain.Avaliacao;

public record AlterarTriagemInput(String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
