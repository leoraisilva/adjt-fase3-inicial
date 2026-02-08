package br.com.fiap.hospital.usuario.application.useCase.inbound.listUsaurio;

import br.com.fiap.hospital.usuario.application.useCase.inbound.UsuarioPort;

import java.util.List;

public class ListUsuario {
    private final UsuarioPort usuarioPort;
    public ListUsuario (UsuarioPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public List<ListUsuarioOutput> listUsuario () {
        return usuarioPort.listUsuario();
    }
}
