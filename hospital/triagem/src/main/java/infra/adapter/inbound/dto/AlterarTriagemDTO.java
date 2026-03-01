package infra.adapter.inbound.dto;

import application.domain.Anamnese;
import application.domain.Avaliacao;
import application.useCase.inbound.alterarTriagem.AlterarTriagemInput;

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
