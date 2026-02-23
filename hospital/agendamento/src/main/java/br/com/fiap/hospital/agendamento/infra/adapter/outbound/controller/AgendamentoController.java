package br.com.fiap.hospital.agendamento.infra.adapter.outbound.controller;

import br.com.fiap.hospital.agendamento.application.domain.AgendamentoFactory;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.Agendar;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.agendar.AgendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta.BuscarConsulta;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.buscarConsulta.BuscarConsultaOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.cancelar.Cancelar;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.cancelar.CancelarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.Reagendar;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarInput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.reagendar.ReagendarOutput;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.verificar.Verificar;
import br.com.fiap.hospital.agendamento.application.useCase.inbound.verificar.VerificarOutput;
import br.com.fiap.hospital.agendamento.infra.adapter.inbound.dto.AgendarDTO;
import br.com.fiap.hospital.agendamento.infra.adapter.inbound.dto.ReagendarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hospital/agendamento/api/v1")
public class AgendamentoController {

    private final Agendar agendar;
    private final BuscarConsulta buscarConsulta;
    private final Cancelar cancelar;
    private final Reagendar reagendar;
    private final Verificar verificar;
    private final AgendamentoFactory factory;

    public AgendamentoController(Agendar agendar, BuscarConsulta buscarConsulta, Cancelar cancelar, Reagendar reagendar, Verificar verificar, AgendamentoFactory factory) {
        this.agendar = agendar;
        this.buscarConsulta = buscarConsulta;
        this.cancelar = cancelar;
        this.reagendar = reagendar;
        this.verificar = verificar;
        this.factory = factory;
    }

    @PostMapping ("/agendar")
    public ResponseEntity<AgendarOutput> agendar (@RequestBody AgendarDTO agendarDTO) {
        var idAgendamento = UUID.randomUUID().toString();
        var agendarInput = factory.newAgendamento(
                idAgendamento,
                agendarDTO.paciente(),
                agendarDTO.consulta(),
                agendarDTO.responsavel(),
                agendarDTO.dataConsulta(),
                agendarDTO.reagendavel()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(agendar.agendar(AgendarInput.fromDomain(agendarInput)));
    }

    @PutMapping("/reagendar")
    public ResponseEntity<ReagendarOutput> reagendar (@RequestBody ReagendarDTO reagendarDTO) {
        var reagendarInput = factory.newAgendamento(
                reagendarDTO.idAgendamento(),
                reagendarDTO.paciente(),
                reagendarDTO.consulta(),
                reagendarDTO.responsavel(),
                reagendarDTO.dataConsulta(),
                reagendarDTO.reagendavel()
        );
        return ResponseEntity.status(HttpStatus.OK).body(reagendar.reagendar(ReagendarInput.fromDomain(reagendarInput)));
    }

    @GetMapping("/verificar")
    public ResponseEntity<List<VerificarOutput>> verificar () {
        return ResponseEntity.status(HttpStatus.OK).body(verificar.verificar());
    }

    @GetMapping("/buscarConsulta/{id}")
    public ResponseEntity<BuscarConsultaOutput> buscarConsulta (@PathVariable (value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(buscarConsulta.buscarConsulta(id));
    }

    @DeleteMapping("/cancelar/{id}")
    public ResponseEntity<CancelarOutput> cancelar (@PathVariable (value = "id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(cancelar.cancelar(id));
    }
}
