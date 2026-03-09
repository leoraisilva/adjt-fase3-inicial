package br.com.fiap.hospital.triagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository",
                                        "br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository"})
@EntityScan(basePackages = {"br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity",
                            "br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.entity"})
public class TriagemApplication {
    public static void main(String[] args) {
        SpringApplication.run(TriagemApplication.class, args);
    }
}
