package br.com.fiap.hospital.historico.infra.config;

import br.com.fiap.hospital.agendamento.application.domain.AgendamentoFactory;
import br.com.fiap.hospital.historico.application.domain.DefaultHistoricoFactory;
import br.com.fiap.hospital.historico.application.domain.HistoricoFactory;
import br.com.fiap.hospital.historico.application.service.HistoricoService;
import br.com.fiap.hospital.historico.application.useCase.inbound.HistoricoPorts;
import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistorico;
import br.com.fiap.hospital.historico.application.useCase.outbound.HistoricoRepository;
import br.com.fiap.hospital.historico.infra.adapter.inbound.mapper.HistoricoMapper;
import br.com.fiap.hospital.historico.infra.adapter.inbound.mapper.IHistoricoMapper;
import br.com.fiap.hospital.notificacao.application.domain.NotificacaoFactory;
import br.com.fiap.hospital.triagem.application.domain.AnamneseFactory;
import br.com.fiap.hospital.triagem.application.domain.AvaliacaoFactory;
import br.com.fiap.hospital.triagem.application.domain.TriagemFactory;
import br.com.fiap.hospital.usuario.application.domain.UsuarioFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HistoricoConfig {
    @Bean
    AcessarHistorico acessarHistorico (HistoricoPorts historicoPorts) {
        return new AcessarHistorico(historicoPorts);
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
    IHistoricoMapper historicoMapper (HistoricoFactory historicoFactory, TriagemFactory triagemFactory, NotificacaoFactory notificacaoFactory, UsuarioFactory usuarioFactory, AgendamentoFactory agendamentoFactory, AvaliacaoFactory avaliacaoFactory, AnamneseFactory anamneseFactory) {
        return new HistoricoMapper(historicoFactory);
    }

}
