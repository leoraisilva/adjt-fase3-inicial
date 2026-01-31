package br.com.fiap.hospital.usuario.application.useCase.getUsuario;

import br.com.fiap.hospital.usuario.application.useCase.UsuarioPort;

public class GetUsuario {
    private final UsuarioPort usuarioPort;
    public GetUsuario(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    GetUsuarioOutput getUsuario (String username) {
        return usuarioPort.getUsuario(username);
    }
}
