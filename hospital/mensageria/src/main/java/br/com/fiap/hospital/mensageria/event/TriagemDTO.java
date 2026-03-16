package br.com.fiap.hospital.mensageria.event;

public record TriagemDTO(String paciente, String responsavel, AnamneseDTO anamnese, AvaliacaoDTO avaliacao) {
}
