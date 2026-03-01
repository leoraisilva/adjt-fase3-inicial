package application.useCase.inbound.gerarTriagem;

import application.domain.Anamnese;
import application.domain.Avaliacao;
import application.domain.Triagem;

public record GerarTriagemInput(String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
    public static Triagem toDomain (GerarTriagemInput input) {
        return new Triagem.TriagemBuilder()
                .withPaciente(input.paciente())
                .withResponsavel(input.responsavel())
                .withAnamnese(input.anamese())
                .withAvaliacao(input.avaliacao())
                .build();
    }

    public static GerarTriagemInput toInput (Triagem triagem) {
        return new GerarTriagemInput(
                triagem.getPaciente(),
                triagem.getResponsavel(),
                triagem.getAnamnese(),
                triagem.getAvaliacao()
        );
    }
}
