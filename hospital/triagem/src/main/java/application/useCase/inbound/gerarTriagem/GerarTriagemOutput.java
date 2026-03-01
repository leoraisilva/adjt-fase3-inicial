package application.useCase.inbound.gerarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;
import application.domain.Triagem;

public record GerarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
    public static Triagem toDomain (GerarTriagemOutput output) {
        return new Triagem.TriagemBuilder()
                .withIdTriagem(output.idTriagem())
                .withPaciente(output.paciente())
                .withResponsavel(output.responsavel())
                .withAnamnese(output.anamese())
                .withAvaliacao(output.avaliacao())
                .build();
    }

    public static GerarTriagemOutput toOutput (Triagem triagem) {
        return new GerarTriagemOutput(
                triagem.getIdTriagem(),
                triagem.getPaciente(),
                triagem.getResponsavel(),
                triagem.getAnamnese(),
                triagem.getAvaliacao()
        );
    }
}
