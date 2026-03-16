package br.com.fiap.hospital.historico.infra.adapter.inbound.mapper;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.historico.application.domain.Historico;
import br.com.fiap.hospital.historico.application.domain.HistoricoFactory;
import br.com.fiap.hospital.historico.infra.adapter.outbound.persistent.entity.HistoricoEntity;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.time.LocalDate;

public class HistoricoMapper implements IHistoricoMapper {
    private final HistoricoFactory factory;
    public HistoricoMapper(HistoricoFactory factory) {
        this.factory = factory;
    }

    public Historico toDomain (HistoricoEntity entity, Usuario paciente, Agendamento consulta, Notificacao mensagem, Triagem triagem) {
        return factory.newHistorico(
                paciente,
                consulta,
                mensagem,
                triagem,
                LocalDate.parse(entity.getDataRegistro()),
                entity.getResultado()
        );
    }

    public HistoricoEntity toEntity (Historico historico) {
        return new HistoricoEntity(
                historico.getPaciente().getUsername(),
                historico.getConsulta().getIdAgendamento(),
                historico.getMensagem().getIdMensagem(),
                historico.getTriagem().getIdTriagem(),
                historico.getDataRegistro().toString(),
                historico.getResultado()
        );
    }

}
