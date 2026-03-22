package br.com.fiap.hospital.historico.infra.adapter.consumer;

import br.com.fiap.hospital.agendamento.infra.adapter.inbound.mapper.IAgendamentoMapper;
import br.com.fiap.hospital.historico.infra.adapter.gateway.HistoricoImplRepository;
import br.com.fiap.hospital.historico.infra.adapter.inbound.mapper.IHistoricoMapper;
import br.com.fiap.hospital.mensageria.event.HistoricoDTO;
import br.com.fiap.hospital.notificacao.infra.adapter.inbound.mapper.INotificacaoMapper;
import br.com.fiap.hospital.triagem.infra.adapter.inbound.mapper.ITriagemMapper;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper.IUsuarioMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HistoricoConsumer {
    private final HistoricoImplRepository service;
    private final IHistoricoMapper historicoMapper;
    private final INotificacaoMapper mensagemMapper;
    private final IUsuarioMapper pacienteMapper;
    private final ITriagemMapper triagemMapper;
    private final IAgendamentoMapper agendamentoMapper;

    public HistoricoConsumer(HistoricoImplRepository service, IHistoricoMapper historicoMapper, INotificacaoMapper mensagemMapper, IUsuarioMapper pacienteMapper, ITriagemMapper triagemMapper, IAgendamentoMapper agendamentoMapper) {
        this.service = service;
        this.historicoMapper = historicoMapper;
        this.mensagemMapper = mensagemMapper;
        this.pacienteMapper = pacienteMapper;
        this.triagemMapper = triagemMapper;
        this.agendamentoMapper = agendamentoMapper;
    }

    @KafkaListener(topics = "mensageria-historico")
    public void toConsume (HistoricoDTO mensagem) {
        salvar (mensagem);
    }

    private void salvar (HistoricoDTO mensagem) {
        service.registrar(mensagem);
    }
}
