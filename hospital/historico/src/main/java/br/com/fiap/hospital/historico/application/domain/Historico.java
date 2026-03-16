package br.com.fiap.hospital.historico.application.domain;

import br.com.fiap.hospital.agendamento.application.domain.Agendamento;
import br.com.fiap.hospital.notificacao.application.domain.Notificacao;
import br.com.fiap.hospital.triagem.application.domain.Triagem;
import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.time.LocalDate;

public class Historico {

    private final Usuario paciente;
    private final Agendamento consulta;
    private final Notificacao mensagem;
    private final Triagem triagem;
    private final LocalDate dataRegistro;
    private final String resultado;

    public Historico(HistoricoBuilder builder) {
        this.paciente = builder.paciente;
        this.consulta = builder.consulta;
        this.mensagem = builder.mensagem;
        this.triagem = builder.triagem;
        this.dataRegistro = builder.dataRegistro;
        this.resultado = builder.resultado;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public Agendamento getConsulta() {
        return consulta;
    }

    public Notificacao getMensagem() {
        return mensagem;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public LocalDate getDataRegistro() {
        return  dataRegistro;
    }

    public String getResultado() {
        return resultado;
    }

    public static class HistoricoBuilder {
        private Usuario paciente;
        private Agendamento consulta;
        private Notificacao mensagem;
        private Triagem triagem;
        private LocalDate dataRegistro;
        private String resultado;


        public HistoricoBuilder withPaciente (Usuario paciente) {
            this.paciente = paciente;
            return this;
        }

        public HistoricoBuilder withConsulta (Agendamento consulta) {
            this.consulta = consulta;
            return this;
        }

        public HistoricoBuilder withMensagem (Notificacao mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public HistoricoBuilder withTriagem (Triagem triagem) {
            this.triagem = triagem;
            return this;
        }

        public HistoricoBuilder withResultado (String resultado) {
            this.resultado = resultado;
            return this;
        }

        public HistoricoBuilder withDataRegistro (LocalDate dataRegistro) {
            this.dataRegistro = dataRegistro;
            return this;
        }

        public Historico build () {
            return new Historico(this);
        }
    }

}
