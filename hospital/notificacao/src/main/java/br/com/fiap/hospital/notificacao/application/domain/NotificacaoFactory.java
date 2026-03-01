package br.com.fiap.hospital.notificacao.application.domain;

public interface NotificacaoFactory {
    Notificacao newNotificacao (String idMensagem, String categoria, String titulo, String mensagem, String nome, String email, String tell);
}
