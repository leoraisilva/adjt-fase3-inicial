package br.com.fiap.hospital.historico.application.useCase.inbound.registrar;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

public record RegistrarHistoricoInput(Usuario paciente, Agendamento consulta, Notificacao mensagem, Triagem triagem, String resultado) {
    public static Historico toDomain (RegistrarHistoricoInput input) {
        return new Historico.HistoricoBuilder()
                .withPaciente(input.paciente())
                .withConsulta(input.consulta())
                .withMensagem(input.mensagem())
                .withTriagem(input.triagem())
                .withResultado(input.resultado())
                .build();
    }

    public static RegistrarHistoricoInput toOutput (Historico historico) {
        return new RegistrarHistoricoInput(
                historico.getPaciente(),
                historico.getConsulta(),
                historico.getMensagem(),
                historico.getTriagem(),
                historico.getResultado()
        );
    }
}
