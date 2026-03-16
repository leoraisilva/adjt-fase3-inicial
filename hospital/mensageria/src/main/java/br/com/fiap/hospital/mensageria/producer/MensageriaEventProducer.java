package br.com.fiap.hospital.mensageria.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MensageriaEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MensageriaEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendHistorico(Object event) {
        kafkaTemplate.send("mensageria-historico", event);
    }

}
