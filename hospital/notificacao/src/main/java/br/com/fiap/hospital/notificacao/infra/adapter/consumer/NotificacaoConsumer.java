package br.com.fiap.hospital.notificacao.infra.adapter.consumer;


import br.com.fiap.hospital.mensageria.event.MensagemDTO;
import br.com.fiap.hospital.notificacao.application.domain.Categoria;
import br.com.fiap.hospital.notificacao.application.domain.NotificacaoFactory;
import br.com.fiap.hospital.notificacao.infra.adapter.gateway.handler.NotificacaoHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NotificacaoConsumer {
    private final NotificacaoHandler handler;
    private final NotificacaoFactory notificacaoFactory;

    public NotificacaoConsumer(NotificacaoHandler handler, NotificacaoFactory notificacaoFactory) {
        this.handler = handler;
        this.notificacaoFactory = notificacaoFactory;
    }

    @KafkaListener(topics = "evento-mensagem")
    public void enviarMensagem (MensagemDTO mensagemDTO) {
        var notificacao = notificacaoFactory.newNotificacao(
                UUID.randomUUID().toString(),
                Categoria.valueOf(mensagemDTO.categoria()),
                "",
                "",
                mensagemDTO.nome(),
                mensagemDTO.email(),
                mensagemDTO.tell()
        );
        if(mensagemDTO.categoria().equals(Categoria.CONSULTA.name())) handler.consulta(notificacao);
        else if(mensagemDTO.categoria().equals(Categoria.TRIAGEM.name())) handler.triagem(notificacao);
        else if(mensagemDTO.categoria().equals(Categoria.RETORNO.name())) handler.retorno(notificacao);
        else if(mensagemDTO.categoria().equals(Categoria.CANCELADO.name())) handler.cancelamento(notificacao);
    }

}
