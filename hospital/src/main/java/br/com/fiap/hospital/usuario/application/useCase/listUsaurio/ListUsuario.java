package br.com.fiap.hospital.usuario.application.useCase.listUsaurio;

import br.com.fiap.hospital.usuario.application.useCase.UsuarioPort;

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
