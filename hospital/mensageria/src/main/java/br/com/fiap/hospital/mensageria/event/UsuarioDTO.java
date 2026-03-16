package br.com.fiap.hospital.mensageria.event;

public record UsuarioDTO (String idUsuario, String nome, String username, String senha, String dataNascimento, String tipo, String CPF, String email, String tell) {

}
