package br.com.fiap.hospital.triagem.application.domain;

public interface TriagemFactory {
    Triagem newTriagem (String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao);
}
