package br.com.fiap.hospital.usuario.application.useCase.outbound;

import br.com.fiap.hospital.usuario.application.domain.Usuario;

import java.util.List;

public interface UsuarioRepository {
    Usuario create (Usuario usuario);
    Usuario update (Usuario usuario);
    Usuario findByUsername (String username);
    List<Usuario> findAll ();
    void delete (String username);

}
