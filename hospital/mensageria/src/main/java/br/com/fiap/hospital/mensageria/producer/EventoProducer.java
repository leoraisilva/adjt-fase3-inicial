package br.com.fiap.hospital.mensageria.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EventoProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventoProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(Object event) {
        kafkaTemplate.send("evento-mensagem", UUID.randomUUID().toString(), event);
    }

}
