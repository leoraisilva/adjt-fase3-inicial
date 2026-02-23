package br.com.fiap.hospital.usuario.application.useCase.inbound.getUsuario;

import br.com.fiap.hospital.usuario.application.useCase.inbound.UsuarioPort;

public class GetUsuario {
    private final UsuarioPort usuarioPort;
    public GetUsuario(UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public GetUsuarioOutput getUsuario (String username) {
        return usuarioPort.getUsuario(username);
    }
}
