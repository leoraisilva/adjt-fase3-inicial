package application.useCase.inbound.alterarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;
import application.domain.Triagem;

public record AlterarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
    public static Triagem toDomain (AlterarTriagemOutput output) {
        return new Triagem.TriagemBuilder()
                .withIdTriagem(output.idTriagem())
                .withPaciente(output.paciente())
                .withResponsavel(output.responsavel())
                .withAnamnese(output.anamese())
                .withAvaliacao(output.avaliacao())
                .build();
    }

    public static AlterarTriagemOutput toOutput (Triagem triagem) {
        return new AlterarTriagemOutput(
                triagem.getIdTriagem(),
                triagem.getPaciente(),
                triagem.getResponsavel(),
                triagem.getAnamnese(),
                triagem.getAvaliacao()
        );
    }
}
