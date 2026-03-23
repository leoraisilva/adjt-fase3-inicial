package br.com.fiap.hospital.notificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "br.com.fiap.hospital.mensageria",
        "br.com.fiap.hospital.notificacao",
        "br.com.fiap.hospital.usuario"
})

public class NotificacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificacaoApplication.class, args);
    }
}
