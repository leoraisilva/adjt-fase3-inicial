package br.com.fiap.hospital.historico.application.domain;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.time.LocalDateTime;

public class Historico {
    private Usuario paciente;
    private Agendamento consulta;
    private String resultado;
    private Notificacao mensagem;

}
