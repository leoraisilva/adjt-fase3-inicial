package br.com.fiap.hospital.triagem.infra.adapter.inbound.dto;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.application.domain.Avaliacao;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagemInput;

public record GerarTriagemDTO(String paciente, String responsavel, Anamnese anamnese, Avaliacao avaliacao) {
    public static GerarTriagemInput toInput(GerarTriagemDTO gerarTriagemDTO) {
        return new GerarTriagemInput(
                gerarTriagemDTO.paciente(),
                gerarTriagemDTO.responsavel(),
                gerarTriagemDTO.anamnese(),
                gerarTriagemDTO.avaliacao()
        );
    }
}
