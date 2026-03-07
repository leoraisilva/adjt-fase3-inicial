package br.com.fiap.hospital.notificacao.application.domain;

public class DefaultNotificacaoFactory implements NotificacaoFactory{
    public DefaultNotificacaoFactory (){}
    @Override
    public Notificacao newNotificacao(String idMensagem, Categoria categoria, String titulo, String mensagem, String nome, String email, String tell) {
        return new Notificacao.NotificacaoBuilder()
                .withIdMensagem(idMensagem)
                .withCategoria(categoria)
                .withTitulo(titulo)
                .withMensagem(mensagem)
                .withNome(nome)
                .withEmail(email)
                .withTell(tell)
                .build();
    }
}
