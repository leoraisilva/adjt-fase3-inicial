package application.useCase.inbound.consultarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;
import application.domain.Triagem;

public record ConsultarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
    public static Triagem toDomain (ConsultarTriagemOutput output) {
        return new Triagem.TriagemBuilder()
                .withIdTriagem(output.idTriagem())
                .withPaciente(output.paciente())
                .withResponsavel(output.responsavel())
                .withAnamnese(output.anamese())
                .withAvaliacao(output.avaliacao())
                .build();
    }

    public static ConsultarTriagemOutput toOutput (Triagem triagem) {
        return new ConsultarTriagemOutput(
                triagem.getIdTriagem(),
                triagem.getPaciente(),
                triagem.getResponsavel(),
                triagem.getAnamnese(),
                triagem.getAvaliacao()
        );
    }
}
