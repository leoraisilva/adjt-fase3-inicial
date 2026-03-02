package br.com.fiap.hospital.triagem.application.useCase.inbound.alterarTriagem;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.application.domain.Avaliacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;

public record AlterarTriagemInput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
    public static Triagem toDomain (AlterarTriagemInput input) {
        return new Triagem.TriagemBuilder()
                .withIdTriagem(input.idTriagem())
                .withPaciente(input.paciente())
                .withResponsavel(input.responsavel())
                .withAnamnese(input.anamese())
                .withAvaliacao(input.avaliacao())
                .build();
    }

    public static AlterarTriagemInput toInput (Triagem triagem) {
        return new AlterarTriagemInput(
                triagem.getIdTriagem(),
                triagem.getPaciente(),
                triagem.getResponsavel(),
                triagem.getAnamnese(),
                triagem.getAvaliacao()
        );
    }
}
