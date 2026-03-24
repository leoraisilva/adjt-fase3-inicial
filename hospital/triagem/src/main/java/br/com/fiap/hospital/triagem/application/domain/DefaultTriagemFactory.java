package br.com.fiap.hospital.triagem.application.domain;

public class DefaultTriagemFactory implements TriagemFactory{
    public DefaultTriagemFactory () {}
    @Override
    public Triagem newTriagem(String idTriagem, String paciente, String responsavel, Anamnese anamnese, Avaliacao avaliacao) {
        return new Triagem.TriagemBuilder()
                .withIdTriagem(idTriagem)
                .withPaciente(paciente)
                .withResponsavel(responsavel)
                .withAnamnese(anamnese)
                .withAvaliacao(avaliacao)
                .build();
    }
}
