package br.com.fiap.hospital.triagem.application.useCase.outbound;

import br.com.fiap.hospital.triagem.application.domain.Triagem;

public interface TriagemRepository {
    Triagem gerarTriagem (Triagem triagem);
    Triagem alterarTriagem (Triagem triagem);
    Triagem consultarTriagem (String idTriagem);
}
