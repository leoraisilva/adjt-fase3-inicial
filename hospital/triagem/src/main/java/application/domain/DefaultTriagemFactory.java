package application.domain;

public class DefaultTriagemFactory implements TriagemFactory{
    @Override
    public Triagem newTriagem(String idTriagem, String paciente, String responsavel, Anamnese anamese, Avaliacao avaliacao) {
        return new Triagem.TriagemBuilder()
                .withIdTriagem(idTriagem)
                .withPaciente(paciente)
                .withResponsavel(responsavel)
                .withAnamnese(anamese)
                .withAvaliacao(avaliacao)
                .build();
    }
}
