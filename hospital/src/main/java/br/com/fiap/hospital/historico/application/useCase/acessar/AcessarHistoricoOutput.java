package br.com.fiap.hospital.historico.application.useCase.acessar;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

public record AcessarHistoricoOutput(Usuario paciente, Agendamento consulta, Notificacao mensagem, Triagem triagem, String resultado) {
}
