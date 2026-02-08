package br.com.fiap.hospital.triagem.application.useCase.gerarTriagem;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.application.domain.Avaliacao;

public record GerarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
}
