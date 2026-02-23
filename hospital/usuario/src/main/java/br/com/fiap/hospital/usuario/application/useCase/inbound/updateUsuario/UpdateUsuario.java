package br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario;

import br.com.fiap.hospital.usuario.application.useCase.inbound.UsuarioPort;

public class UpdateUsuario {
    private final UsuarioPort usuarioPort;
    public UpdateUsuario (UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public UpdateUsuarioOutput updateUsuario (UpdateUsuarioInput input) {
        return usuarioPort.updateUsuario(input);
    }
}
