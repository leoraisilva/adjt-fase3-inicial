package br.com.fiap.hospital.usuario.application.service;

import br.com.fiap.hospital.usuario.application.useCase.inbound.UsuarioPort;
import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.deleteUsuario.DeleteUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.getUsuario.GetUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.listUsaurio.ListUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.outbound.UsuarioRepository;

import java.util.List;

public class UsuarioService implements UsuarioPort {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateUsuarioOutput createUsuario(CreateUsuarioInput input) {
        return CreateUsuarioOutput.fromDomain(repository.create(CreateUsuarioInput.toDomain(input)));
    }

    @Override
    public UpdateUsuarioOutput updateUsuario(UpdateUsuarioInput input) {
        return UpdateUsuarioOutput.fromDomain(repository.update(UpdateUsuarioInput.toDomain(input)));
    }

    @Override
    public GetUsuarioOutput getUsuario(String username) {
        return GetUsuarioOutput.fromDomain(repository.findByUsername(username));
    }

    @Override
    public DeleteUsuarioOutput deleteUsuario(String username) {
        var response = DeleteUsuarioOutput.fromDomain(repository.findByUsername(username));
        repository.delete(username);
        return response;
    }

    @Override
    public List<ListUsuarioOutput> listUsuario() {
        return repository.findAll().stream()
                .map(ListUsuarioOutput::fromDomain)
                .toList();

    }
}
