package br.com.fiap.hospital.usuario.infra.adapter.outbound.controller;

import br.com.fiap.hospital.usuario.application.domain.UsuarioFactory;
import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.createUsuario.CreateUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.deleteUsuario.DeleteUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.deleteUsuario.DeleteUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.getUsuario.GetUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.getUsuario.GetUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.listUsaurio.ListUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.listUsaurio.ListUsuarioOutput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuario;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuarioInput;
import br.com.fiap.hospital.usuario.application.useCase.inbound.updateUsuario.UpdateUsuarioOutput;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.dto.LoginDTO;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.dto.UsuarioCreateDTO;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.dto.UsuarioUpdateDTO;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.dto.TokenDTO;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity.UsuarioEntity;
import br.com.fiap.hospital.usuario.infra.config.security.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/hospital/usuario/api/v1")
public class UsuarioController {

    private final CreateUsuario createUsuario;
    private final UpdateUsuario updateUsuario;
    private final DeleteUsuario deleteUsuario;
    private final GetUsuario getUsuario;
    private final ListUsuario listUsuario;
    private final UsuarioFactory factory;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UsuarioController(CreateUsuario createUsuario, UpdateUsuario updateUsuario, DeleteUsuario deleteUsuario, GetUsuario getUsuario, ListUsuario listUsuario, UsuarioFactory factory, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.createUsuario = createUsuario;
        this.updateUsuario = updateUsuario;
        this.deleteUsuario = deleteUsuario;
        this.getUsuario = getUsuario;
        this.listUsuario = listUsuario;
        this.factory = factory;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/auth/login")
    public ResponseEntity<TokenDTO> login (@RequestBody LoginDTO loginDTO) {
        var user = new UsernamePasswordAuthenticationToken(loginDTO.username(), loginDTO.password());
        var auth = authenticationManager.authenticate(user);
        var token = tokenService.GenerationToken((UsuarioEntity) auth.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO(token));
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUsuarioOutput> usuarioCreate (@RequestBody UsuarioCreateDTO usuarioDTO) {
        var newUsuario = factory.usuarioFactory(usuarioDTO.nome(),
                usuarioDTO.username(),
                usuarioDTO.senha(),
                usuarioDTO.dataNascimento(),
                usuarioDTO.CPF(),
                usuarioDTO.email(),
                usuarioDTO.tell(),
                usuarioDTO.tipo());
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsuario.createUsuario(CreateUsuarioInput.fromDomain(newUsuario)));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUsuarioOutput> usuarioUpdate (@RequestBody UsuarioUpdateDTO usuarioDTO) {
        var updateNewUsuario = factory.usuarioFactory(
                usuarioDTO.nome(),
                usuarioDTO.username(),
                usuarioDTO.senha(),
                usuarioDTO.dataNascimento(),
                usuarioDTO.CPF(),
                usuarioDTO.email(),
                usuarioDTO.tell(),
                usuarioDTO.tipo());
        return ResponseEntity.status(HttpStatus.OK).body(updateUsuario.updateUsuario(UpdateUsuarioInput.fromDomain(updateNewUsuario)));
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<GetUsuarioOutput> usuarioGet (@PathVariable (value = "username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body(getUsuario.getUsuario(username));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ListUsuarioOutput>> usuarioList () {
        return ResponseEntity.status(HttpStatus.OK).body(listUsuario.listUsuario());
    }

    @DeleteMapping("/delete/{username}")
    private ResponseEntity<DeleteUsuarioOutput> deleteUsuario (@PathVariable (value = "username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body(deleteUsuario.deleteUsuario(username));
    }
}
