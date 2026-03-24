package br.com.fiap.hospital.triagem.infra.adapter.inbound.dto;

import br.com.fiap.hospital.triagem.application.domain.*;
import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagemInput;

import java.util.UUID;

public record AlterarTriagemDTO(String idTriagem, String paciente, String responsavel, AlterarAnamneseDTO anamnese, AlterarAvaliacaoDTO avaliacao) {
    private static final AnamneseFactory anamneseFactory = new DefaultAnamneseFactory();
    private static final AvaliacaoFactory avaliacaoFactory = new DefaultAvaliacaoFactory();
    public static AlterarTriagemInput toInput (AlterarTriagemDTO dto) {
        return new AlterarTriagemInput(
                dto.idTriagem(),
                dto.paciente(),
                dto.responsavel(),
                anamneseFactory.newAnamnese(
                        dto.anamnese().idAnamnese(),
                        dto.anamnese().descricao(),
                        dto.anamnese().dores(),
                        dto.anamnese().diabete(),
                        dto.anamnese().pressaoAlta(),
                        dto.anamnese().coracao(),
                        dto.anamnese().historicoFamilia(),
                        dto.anamnese().membroFamilia()
                ),
                avaliacaoFactory.newAvaliacao(
                        dto.avaliacao().idAvaliacao(),
                        dto.avaliacao().pressao(),
                        dto.avaliacao().oxigenacao(),
                        dto.avaliacao().quadroClinico(),
                        dto.avaliacao().risco()
                )
        );
    }
}
