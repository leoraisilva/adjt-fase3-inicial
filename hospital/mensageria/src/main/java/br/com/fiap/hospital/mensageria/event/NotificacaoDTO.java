package br.com.fiap.hospital.mensageria.event;

public record NotificacaoDTO(String idMensagem, String categoria, String titulo, String mensagem, String nome, String email, String tell) {
}
