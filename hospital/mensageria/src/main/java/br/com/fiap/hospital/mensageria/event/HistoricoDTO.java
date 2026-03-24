package br.com.fiap.hospital.mensageria.event;

public record HistoricoDTO(UsuarioDTO usuario, AgendamentoDTO agendamento, NotificacaoDTO mensagem, TriagemDTO triagem, String dataRegistro, String resultado) {
}
