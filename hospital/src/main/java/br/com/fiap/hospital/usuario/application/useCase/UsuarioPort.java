package br.com.fiap.hospital.usuario.application.useCase;

import br.com.fiap.hospital.usuario.application.useCase.createUsuario.CreateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.createUsuario.CreateUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.deleteUsuario.DeleteUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.getUsuario.GetUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.listUsaurio.ListUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.updateUsuario.UpdateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.updateUsuario.UpdateUsuarioOutput;

import java.util.List;

public interface UsuarioPort {
    CreateUsuarioOutput createUsuario (CreateUsuarioInput input);
    UpdateUsuarioOutput updateUsuario (UpdateUsuarioInput input);
    GetUsuarioOutput getUsuario (String username);
    DeleteUsuarioOutput deleteUsuario (String username);
    List<ListUsuarioOutput> listUsuario ();
}
