package br.com.fiap.hospital.triagem.infra.adapter.inbound.dto;

import br.com.fiap.hospital.triagem.application.domain.*;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagemInput;

import java.util.UUID;

public record GerarTriagemDTO(String paciente, String responsavel, GerarAnamneseDTO anamnese, GerarAvaliacaoDTO avaliacao) {
    private static final AnamneseFactory anamneseFactory = new DefaultAnamneseFactory();
    private static final AvaliacaoFactory avaliacaoFactory = new DefaultAvaliacaoFactory();
    public static GerarTriagemInput toInput(GerarTriagemDTO gerarTriagemDTO) {
        return new GerarTriagemInput(
                gerarTriagemDTO.paciente(),
                gerarTriagemDTO.responsavel(),
                anamneseFactory.newAnamnese(
                        UUID.randomUUID().toString(),
                        gerarTriagemDTO.anamnese().descricao(),
                        gerarTriagemDTO.anamnese().dores(),
                        gerarTriagemDTO.anamnese().diabete(),
                        gerarTriagemDTO.anamnese().pressaoAlta(),
                        gerarTriagemDTO.anamnese().coracao(),
                        gerarTriagemDTO.anamnese().historicoFamilia(),
                        gerarTriagemDTO.anamnese().membroFamilia()
                ),
                avaliacaoFactory.newAvaliacao(
                        UUID.randomUUID().toString(),
                        gerarTriagemDTO.avaliacao().pressao(),
                        gerarTriagemDTO.avaliacao().oxigenacao(),
                        gerarTriagemDTO.avaliacao().quadroClinico(),
                        gerarTriagemDTO.avaliacao().risco()
                )
        );
    }
}
