package br.com.fiap.hospital.usuario.application.useCase.deleteUsuario;

import br.com.fiap.hospital.usuario.application.useCase.UsuarioPort;

public class DeleteUsuario {
    private final UsuarioPort usuarioPort;
    public DeleteUsuario (UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public DeleteUsuarioOutput deleteUsuario (String username) {
        return usuarioPort.deleteUsuario(username);
    }
}
