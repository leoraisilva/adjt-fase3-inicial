package br.com.fiap.hospital.usuario.application.domain;

public enum UserType {
    PACIENTE ("PACIENTE"),
    MEDICO ("MEDICO"),
    ENFERMEIRO ("ENFERMEIRO");

    private String userType;
    UserType (String  userType) {
        this.userType = userType;
    };
}
