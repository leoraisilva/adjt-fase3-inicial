package br.com.fiap.hospital.historico.infra.config;

import br.com.fiap.hospital.historico.application.domain.DefaultHistoricoFactory;
import br.com.fiap.hospital.historico.application.domain.HistoricoFactory;
import br.com.fiap.hospital.historico.application.service.HistoricoService;
import br.com.fiap.hospital.historico.application.useCase.inbound.HistoricoPorts;
import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistorico;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistorico;
import br.com.fiap.hospital.historico.application.useCase.outbound.HistoricoRepository;
import br.com.fiap.hospital.historico.infra.adapter.inbound.mapper.HistoricoMapper;
import br.com.fiap.hospital.historico.infra.adapter.inbound.mapper.IHistoricoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HistoricoConfig {
    @Bean
    AcessarHistorico acessarHistorico (HistoricoPorts historicoPorts) {
        return new AcessarHistorico(historicoPorts);
    }
    @Bean
    RegistrarHistorico registrarHistorico (HistoricoPorts historicoPorts) {
        return new RegistrarHistorico(historicoPorts);
    }
    @Bean
    HistoricoPorts historicoPorts (HistoricoRepository repository) {
        return new HistoricoService(repository);
    }
    @Bean
    HistoricoFactory historicoFactory () {
        return new DefaultHistoricoFactory();
    }
    @Bean
    IHistoricoMapper historicoMapper (HistoricoFactory historicoFactory) {
        return new HistoricoMapper(historicoFactory);
    }

}
