package br.com.fiap.hospital.triagem.infra.adapter.inbound.dto;

import br.com.fiap.hospital.triagem.application.domain.Intensidade;

public record GerarAnamneseDTO(String descricao, Intensidade dores, boolean diabete, boolean pressaoAlta, boolean coracao, String historicoFamilia, String membroFamilia) {
}
