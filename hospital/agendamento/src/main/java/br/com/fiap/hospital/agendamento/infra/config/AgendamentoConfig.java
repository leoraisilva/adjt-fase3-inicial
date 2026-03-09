package br.com.fiap.hospital.agendamento.infra.config;

import br.com.fiap.hospital.agendamento.application.domain.AgendamentoFactory;
import br.com.fiap.hospital.agendamento.application.domain.DefaultAgendamentoFactory;
import br.com.fiap.hospital.agendamento.application.service.AgendamentoService;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.AgendamentoPort;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.Agendar;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta.BuscarConsulta;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.cancelar.Cancelar;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.Reagendar;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.verificar.Verificar;
import br.com.fiap.hospital.agendamento.application.useCase.outbound.AgendamentoRepository;
import br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper.AgendamentoMapper;
import br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper.IAgendamentoMapper;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class AgendamentoConfig {
    @Bean
    Agendar agendar(AgendamentoPort agendamentoPort) {
        return new Agendar(agendamentoPort);
    }
    @Bean
    BuscarConsulta buscarConsulta(AgendamentoPort agendamentoPort) {
        return new BuscarConsulta(agendamentoPort);
    }
    @Bean
    Cancelar cancelar(AgendamentoPort agendamentoPort) {
        return new Cancelar(agendamentoPort);
    }
    @Bean
    Reagendar reagendar(AgendamentoPort agendamentoPort) {
        return new Reagendar(agendamentoPort);
    }
    @Bean
    Verificar verificar(AgendamentoPort agendamentoPort) {
        return new Verificar(agendamentoPort);
    }

    @Bean
    AgendamentoPort agendamentoPort (AgendamentoRepository repository){
        return new AgendamentoService(repository);
    }
    @Bean
    AgendamentoFactory factory () {
        return new DefaultAgendamentoFactory();
    }
    @Bean
    IAgendamentoMapper mapper (AgendamentoFactory factory) {
        return new AgendamentoMapper(factory);
    }

}
