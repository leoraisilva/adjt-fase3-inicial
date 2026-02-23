package application.domain;

public interface NotificacaoFactory {
    Notificacao newNotificacao (String idMensagem, String categoria, String titulo, String mensagem, String nome, String email, String tell);
}
