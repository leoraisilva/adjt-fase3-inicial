package br.com.fiap.hospital.triagem.infra.adapter.outbound.controller;

import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagem;
import br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem.AlterarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.consultarTriagem.ConsultarTriagem;
import br.com.fiap.hospital.triagem.application.useCase.inbound.consultarTriagem.ConsultarTriagemOutput;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagem;
import br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem.GerarTriagemOutput;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.dto.GerarTriagemDTO;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.dto.AlterarTriagemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital/triagem/api/v1")
@CrossOrigin("*")
public class TriagemController {
    private final AlterarTriagem alterarTriagem;
    private final ConsultarTriagem consultarTriagem;
    private final GerarTriagem gerarTriagem;

    public TriagemController(AlterarTriagem alterarTriagem, ConsultarTriagem consultarTriagem, GerarTriagem gerarTriagem) {
        this.alterarTriagem = alterarTriagem;
        this.consultarTriagem = consultarTriagem;
        this.gerarTriagem = gerarTriagem;
    }

    @PostMapping("/gerarTriagem")
    public ResponseEntity<GerarTriagemOutput> gerarTriagem (@RequestBody GerarTriagemDTO gerarTriagemDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gerarTriagem.gerarTriagem(GerarTriagemDTO.toInput(gerarTriagemDTO)));
    }

    @GetMapping("/consultarTriagem/{paciente}")
    public ResponseEntity<ConsultarTriagemOutput> consultarTriagem (@PathVariable (value = "paciente") String paciente) {
        return ResponseEntity.status(HttpStatus.OK).body(consultarTriagem.consultarTriagem(paciente));
    }

    @PutMapping("/alterarTriagem")
    public ResponseEntity<AlterarTriagemOutput> alterarTriagem (@RequestBody AlterarTriagemDTO alterarTriagemDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(alterarTriagem.alterarTriagem(AlterarTriagemDTO.toInput(alterarTriagemDTO)));
    }

}
