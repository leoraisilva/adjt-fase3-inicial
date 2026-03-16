package br.com.fiap.hospital.usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "br.com.fiap.hospital.historico",
        "br.com.fiap.hospital.usuario",
        "br.com.fiap.hospital.mensageria"
})
public class UsuarioApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsuarioApplication.class, args);
    }
}
