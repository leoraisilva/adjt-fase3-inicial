package br.com.fiap.hospital.usuario.application.service;

import br.com.fiap.hospital.usuario.application.useCase.UsuarioPort;
import br.com.fiap.hospital.usuario.application.useCase.createUsuario.CreateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.createUsuario.CreateUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.deleteUsuario.DeleteUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.getUsuario.GetUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.listUsaurio.ListUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.updateUsuario.UpdateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.updateUsuario.UpdateUsuarioOutput;

import java.util.List;

public class UsuarioService implements UsuarioPort {
    @Override
    public CreateUsuarioOutput createUsuario(CreateUsuarioInput input) {
        return null;
    }

    @Override
    public UpdateUsuarioOutput updateUsuario(UpdateUsuarioInput input) {
        return null;
    }

    @Override
    public GetUsuarioOutput getUsuario(String username) {
        return null;
    }

    @Override
    public DeleteUsuarioOutput deleteUsuario(String username) {
        return null;
    }

    @Override
    public List<ListUsuarioOutput> listUsuario() {
        return null;
    }
}
