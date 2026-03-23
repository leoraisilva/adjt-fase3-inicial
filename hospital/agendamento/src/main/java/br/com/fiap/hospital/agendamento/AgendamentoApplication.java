package br.com.fiap.hospital.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "br.com.fiap.hospital.historico",
        "br.com.fiap.hospital.usuario",
        "br.com.fiap.hospital.agendamento",
        "br.com.fiap.hospital.mensageria",
        "br.com.fiap.hospital.notificacao"
})
@EnableJpaRepositories(basePackages = {"br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository",
                                        "br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.repository",
                                        "br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.repository"})
@EntityScan(basePackages = {"br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity",
                            "br.com.fiap.hospital.agendamento.infra.adapter.outbound.persistent.entity",
                            "br.com.fiap.hospital.notificacao.infra.adapter.outbound.persistent.entity"})
public class AgendamentoApplication{
    public static void main(String[] args) {
        SpringApplication.run(AgendamentoApplication.class, args);
    }
}
