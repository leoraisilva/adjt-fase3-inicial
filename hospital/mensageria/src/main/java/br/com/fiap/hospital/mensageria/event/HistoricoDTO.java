package br.com.fiap.hospital.mensageria.event;

public record HistoricoDTO(UsuarioDTO usuario, AgendamentoDTO agendamento, NotificacaoDTO notificacao, TriagemDTO triagem, String dataRegistro, String resultado) {
}
