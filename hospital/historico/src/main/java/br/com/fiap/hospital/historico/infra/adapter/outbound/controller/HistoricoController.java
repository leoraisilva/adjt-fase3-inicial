package br.com.fiap.hospital.historico.infra.adapter.outbound.controller;

import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistorico;
import br.com.fiap.hospital.historico.application.useCase.inbound.acessar.AcessarHistoricoOutput;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class HistoricoController {
    private final AcessarHistorico acessarHistorico;

    public HistoricoController(AcessarHistorico acessarHistorico) {
        this.acessarHistorico = acessarHistorico;
    }
    @QueryMapping
    public List<AcessarHistoricoOutput> acessarHistorico (@Argument("paciente") String paciente) {
        return acessarHistorico.acessarHistorico(paciente);
    }

}
