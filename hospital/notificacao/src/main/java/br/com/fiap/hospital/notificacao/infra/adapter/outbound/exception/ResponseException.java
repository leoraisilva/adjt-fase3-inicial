package br.com.fiap.hospital.notificacao.infra.adapter.outbound.exception;

public record ResponseException (String type, String title, int status, String detail, String instance) {
}
