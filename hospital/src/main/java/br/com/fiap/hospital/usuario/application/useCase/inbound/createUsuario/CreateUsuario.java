package br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario;

import br.com.fiap.hospital.usuario.application.useCase.inbound.UsuarioPort;

public class CreateUsuario {
    private final UsuarioPort usuarioPort;
    public CreateUsuario (UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public CreateUsuarioOutput createUsuario (CreateUsuarioInput input) {
        return usuarioPort.createUsuario(input);
    }
}
