package br.com.fiap.hospital.historico.infra.adapter.outbound.controller;

import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistorico;
import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistoricoOutput;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistorico;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistoricoOutput;
import br.com.fiap.hospital.historico.infra.adapter.inbound.dto.InputHistoricoDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HistoricoController {
    private final AcessarHistorico acessarHistorico;
    private final RegistrarHistorico registrarHistorico;

    public HistoricoController(AcessarHistorico acessarHistorico, RegistrarHistorico registrarHistorico) {
        this.acessarHistorico = acessarHistorico;
        this.registrarHistorico = registrarHistorico;
    }

    @MutationMapping
    public RegistrarHistoricoOutput registrarHistorico (@Argument("input") InputHistoricoDTO inputHistoricoDTO) {
        return registrarHistorico.registrarHistorico(InputHistoricoDTO.input(inputHistoricoDTO));
    }

    @QueryMapping
    public List<AcessarHistoricoOutput> acessarHistorico (@Argument("paciente") String paciente) {
        return acessarHistorico.acessarHistorico(paciente);
    }

}
