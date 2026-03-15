package br.com.fiap.hospital.historico.application.useCase.inbound.acessar;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

public record AcessarHistoricoOutput(Usuario paciente, Agendamento consulta, Notificacao mensagem, Triagem triagem, String resultado) {
    public static Historico toDomain (AcessarHistoricoOutput output) {
        return new Historico.HistoricoBuilder()
                .withPaciente(output.paciente())
                .withConsulta(output.consulta())
                .withMensagem(output.mensagem())
                .withTriagem(output.triagem())
                .withResultado(output.resultado())
                .build();
    }

    public static AcessarHistoricoOutput toOutput (Historico historico) {
        return new AcessarHistoricoOutput(
                historico.getPaciente(),
                historico.getConsulta(),
                historico.getMensagem(),
                historico.getTriagem(),
                historico.getResultado()
        );
    }
}
