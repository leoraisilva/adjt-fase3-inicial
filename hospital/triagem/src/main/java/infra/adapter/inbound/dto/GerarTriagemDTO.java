package infra.adapter.inbound.dto;

import application.domain.Anamnese;
import application.domain.Avaliacao;
import application.useCase.inbound.gerarTriagem.GerarTriagemInput;
import application.useCase.inbound.gerarTriagem.GerarTriagemOutput;

public record GerarTriagemDTO(String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
    public static GerarTriagemInput toInput(GerarTriagemDTO gerarTriagemDTO) {
        return new GerarTriagemInput(
                gerarTriagemDTO.paciente(),
                gerarTriagemDTO.responsavel(),
                gerarTriagemDTO.anamese(),
                gerarTriagemDTO.avaliacao()
        );
    }
}
