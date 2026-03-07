package br.com.fiap.hospital.triagem.application.useCase.inbound.gerarTriagem;

import br.com.fiap.hospital.triagem.application.domain.Anamnese;
import br.com.fiap.hospital.triagem.application.domain.Avaliacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;

public record GerarTriagemOutput(String idTriagem, String paciente, String responsavel, Anamnese anamnese, Avaliacao avaliacao) {
    public static Triagem toDomain (GerarTriagemOutput output) {
        return new Triagem.TriagemBuilder()
                .withIdTriagem(output.idTriagem())
                .withPaciente(output.paciente())
                .withResponsavel(output.responsavel())
                .withAnamnese(output.anamnese())
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
