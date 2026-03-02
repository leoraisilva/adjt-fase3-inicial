package br.com.fiap.hospital.triagem.infra.adapter.inbound.dto;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.application.domain.Avaliacao;
import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagemInput;

public record AlterarTriagemDTO(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
    public static AlterarTriagemInput toInput (AlterarTriagemDTO dto) {
        return new AlterarTriagemInput(
                dto.idTriagem(),
                dto.paciente(),
                dto.responsavel(),
                dto.anamese(),
                dto.avaliacao()
        );
    }
}
