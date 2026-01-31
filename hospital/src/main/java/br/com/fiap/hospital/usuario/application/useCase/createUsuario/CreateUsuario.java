package br.com.fiap.hospital.usuario.application.useCase.createUsuario;

import br.com.fiap.hospital.usuario.application.useCase.UsuarioPort;

public class CreateUsuario {
    private final UsuarioPort usuarioPort;
    public CreateUsuario (UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    CreateUsuarioOutput createUsuario (CreateUsuarioInput input) {
        return usuarioPort.createUsuario(input);
    }
}
