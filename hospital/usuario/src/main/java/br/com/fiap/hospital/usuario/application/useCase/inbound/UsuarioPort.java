package br.com.fiap.hospital.usuario.application.useCase.inbound;

import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.deleteUsuario.DeleteUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.getUsuario.GetUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.listUsaurio.ListUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuarioOutput;

import java.util.List;

public interface UsuarioPort {
    CreateUsuarioOutput createUsuario (CreateUsuarioInput input);
    UpdateUsuarioOutput updateUsuario (UpdateUsuarioInput input);
    GetUsuarioOutput getUsuario (String username);
    DeleteUsuarioOutput deleteUsuario (String username);
    List<ListUsuarioOutput> listUsuario ();
}
