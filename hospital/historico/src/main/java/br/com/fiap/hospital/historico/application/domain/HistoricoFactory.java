package br.com.fiap.hospital.historico.application.domain;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

public interface HistoricoFactory {
    Historico newHistorico (Usuario paciente, Agendamento consulta, Notificacao mensagem, Triagem triagem, String resultado);
}
