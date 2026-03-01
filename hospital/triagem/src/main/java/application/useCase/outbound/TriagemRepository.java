package application.useCase.outbound;

import application.domain.Triagem;

public interface TriagemRepository {
    Triagem gerarTriagem (Triagem triagem);
    Triagem alterarTriagem (Triagem triagem);
    Triagem consultarTriagem (String paciente);
}
