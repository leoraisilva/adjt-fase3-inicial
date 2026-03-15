package br.com.fiap.hospital.triagem.infra.config;

import br.com.fiap.hospital.triagem.application.domain.*;
import br.com.fiap.hospital.triagem.application.service.TriagemService;
import br.com.fiap.hospital.triagem.application.useCase.inbound.TriagemPorts;
import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagem;
import br.com.fiap.hospital.triagem.application.useCase.inbound.consultarTriagem.ConsultarTriagem;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagem;
import br.com.fiap.hospital.triagem.application.useCase.outbound.TriagemRepository;
import br.com.fiap.hospital.triagem.infra.adapter.gateway.TriagemImpRepository;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper.*;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AnamneseJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.AvaliacaoJPARepository;
import br.com.fiap.hospital.triagem.infra.adapter.outbound.persistent.repository.TriagemJPARepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TriagemConfig {
    @Bean
    AlterarTriagem alterarTriagem (TriagemPorts triagemPorts) {
        return new AlterarTriagem(triagemPorts);
    }
    @Bean
    ConsultarTriagem consultarTriagem (TriagemPorts triagemPorts) {
        return new ConsultarTriagem(triagemPorts);
    }
    @Bean
    GerarTriagem gerarTriagem (TriagemPorts triagemPorts) {
        return new GerarTriagem(triagemPorts);
    }
    @Bean
    ITriagemMapper triagemMapper (TriagemFactory factory, IAvaliacaoMapper avaliacaoMapper, IAnamneseMapper anamneseMapper) {
        return new TriagemMapper(factory, avaliacaoMapper, anamneseMapper);
    }

    @Bean
    IAvaliacaoMapper avaliacaoMapper (AvaliacaoFactory avaliacaoFactory) {
        return new AvaliacaoMapper(avaliacaoFactory);
    }
    @Bean
    IAnamneseMapper anamneseMapper (AnamneseFactory anamneseFactory){
        return new AnamneseMapper(anamneseFactory);
    }
    @Bean
    AvaliacaoFactory avaliacaoFactory (){
        return new DefaultAvaliacaoFactory();
    }
    @Bean
    AnamneseFactory anamneseFactory (){
        return new DefaultAnamneseFactory();
    }
    @Bean
    TriagemFactory triagemFactory (){
        return new DefaultTriagemFactory();
    }
    @Bean
    TriagemPorts ports (TriagemRepository repository) {
        return new TriagemService(repository);
    }
    @Bean
    TriagemRepository repository (AnamneseJPARepository anamneseJPARepository, AvaliacaoJPARepository avaliacaoJPARepository, TriagemJPARepository triagemJPARepository, ITriagemMapper triagemMapper) {
        return new TriagemImpRepository(anamneseJPARepository, avaliacaoJPARepository, triagemJPARepository,triagemMapper);
    }
}
