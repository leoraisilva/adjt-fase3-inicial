package br.com.fiap.hospital.historico.infra.adapter.inbound.dto;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.agendamento.application.domain.ConsultaType;
import br.com.fiap.hospital.historico.application.useCase.inbound.registrar.RegistrarHistoricoInput;
import br.com.fiap.hospital.notificacao.application.domain.Categoria;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.*;
import br.com.fiap.hospital.usuario.application.domain.UserType;
import br.com.fiap.hospital.usuario.application.domain.Usuario;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SchemaMapping(typeName = "inputHistorico")
public record InputHistoricoDTO (InputUsuarioDTO usuario, InputAgendamentoDTO agendamento, InputNotificacaoDTO notificacao, InputTriagemDTO triagem, String resultado) {
    public static RegistrarHistoricoInput input(InputHistoricoDTO inputDTO) {
        var usuario = new Usuario.UsuarioBuilder()
                .withNome(inputDTO.usuario().nome())
                .withUsername(inputDTO.usuario().username())
                .withSenha(inputDTO.usuario().senha())
                .withCPF(inputDTO.usuario().CPF())
                .withEmail(inputDTO.usuario().email())
                .withUserType(UserType.valueOf(inputDTO.usuario().tipo()))
                .withTell(inputDTO.usuario().tell())
                .withDataNascimento(LocalDate.parse(inputDTO.usuario().dataNascimento()))
                .build();
        var agendamento = new Agendamento.AgendamentoBuilder()
                .withId(inputDTO.agendamento().idAgendamento())
                .withConsulta(ConsultaType.valueOf(inputDTO.agendamento().consulta()))
                .withPaciente(inputDTO.agendamento().paciente())
                .withReagendavel(inputDTO.agendamento().reagendavel())
                .withResponsavel(inputDTO.agendamento().responsavel())
                .withDataConsulta(inputDTO.agendamento().dataConsulta())
                .build();
        var notificacao = new Notificacao.NotificacaoBuilder()
                .withIdMensagem(inputDTO.notificacao().idMensagem())
                .withNome(inputDTO.notificacao().nome())
                .withEmail(inputDTO.notificacao().email())
                .withCategoria(Categoria.valueOf(inputDTO.notificacao().categoria()))
                .withMensagem(inputDTO.notificacao().mensagem())
                .withTell(inputDTO.notificacao().tell())
                .withTitulo(inputDTO.notificacao().titulo())
                .build();
        var anamnese = new Anamnese.AnamneseBuilder()
                .withCoracao(inputDTO.triagem().anamnese().coracao())
                .withDescricao(inputDTO.triagem().anamnese().descricao())
                .withDiabete(inputDTO.triagem().anamnese().diabete())
                .withDores(Intensidade.valueOf(inputDTO.triagem().anamnese().dores()))
                .withPressaoAlta(inputDTO.triagem().anamnese().pressaoAlta())
                .withHistoricoFamilia(inputDTO.triagem().anamnese().historicoFamilia())
                .withMembroFamilia(inputDTO.triagem().anamnese().membroFamilia())
                .build();
        var avaliacao = new Avaliacao.AvaliacaoBuilder()
                .withOxigenacao(inputDTO.triagem().avaliacao().oxigenacao())
                .withPressao(inputDTO.triagem().avaliacao().pressao())
                .withRisco(Classificacao.valueOf(inputDTO.triagem().avaliacao().risco()))
                .withQuadroClinico(inputDTO.triagem().avaliacao().quadroClinico())
                .build();
        var triagem = new Triagem.TriagemBuilder()
                .withPaciente(inputDTO.triagem().paciente())
                .withResponsavel(inputDTO.triagem().responsavel())
                .withAnamnese(anamnese)
                .withAvaliacao(avaliacao)
                .build();
        return new RegistrarHistoricoInput(
                usuario,
                agendamento,
                notificacao,
                triagem,
                inputDTO.resultado()
        );
    }
}
