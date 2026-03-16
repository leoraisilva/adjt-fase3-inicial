package br.com.fiap.hospital.mensageria.event;

public record AnamneseDTO(String descricao, String dores, boolean diabete, boolean pressaoAlta, boolean coracao, String historicoFamilia, String membroFamilia) {
}
