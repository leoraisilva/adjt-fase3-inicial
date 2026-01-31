package br.com.fiap.hospital.usuario.application.useCase.updateUsuario;

import br.com.fiap.hospital.usuario.application.useCase.UsuarioPort;

public class UpdateUsuario {
    private final UsuarioPort usuarioPort;
    public UpdateUsuario (UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    UpdateUsuarioOutput updateUsuario (UpdateUsuarioInput input) {
        return usuarioPort.updateUsuario(input);
    }
}
