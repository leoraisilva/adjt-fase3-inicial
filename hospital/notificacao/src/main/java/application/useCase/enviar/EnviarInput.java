package application.useCase.enviar;

public record EnviarInput (String idMensagem, String categoria, String titulo, String mensagem, String nome, String email, String tell) {
}
