package br.com.fiap.hospital.triagem.infra.adapter.inbound.dto;

import br.com.fiap.hospital.triagem.application.domain.Classificacao;

public record GerarAvaliacaoDTO(String pressao, String oxigenacao, String quadroClinico, Classificacao risco) {
}
