package br.com.fiap.hospital.historico.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.entity.HistoricoEntity;
import br.com.fiap.hospital.mensageria.event.HistoricoDTO;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

public interface IHistoricoMapper {
    Historico toDomain (HistoricoEntity entity, Usuario paciente, Agendamento consulta, Notificacao mensagem, Triagem triagem);
    HistoricoEntity toEntity (Historico historico);
}
