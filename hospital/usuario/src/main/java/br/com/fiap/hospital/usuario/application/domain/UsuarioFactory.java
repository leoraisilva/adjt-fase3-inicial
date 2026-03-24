package br.com.fiap.hospital.usuario.application.domain;

import java.time.LocalDate;

public interface UsuarioFactory {
    Usuario usuarioFactory (String nome, String username, String senha, LocalDate dataNascimento, String CPF, String email, String tell, UserType tipo);
}
