package br.com.fiap.hospital.usuario.infra.adapter.gateway;

import br.com.fiap.hospital.mensageria.event.HistoricoDTO;
import br.com.fiap.hospital.mensageria.event.UsuarioDTO;
import br.com.fiap.hospital.mensageria.producer.MensageriaEventProducer;
import br.com.fiap.hospital.usuario.application.domain.Usuario;
import br.com.fiap.hospital.usuario.application.domain.UsuarioFactory;
import br.com.fiap.hospital.usuario.application.useCase.outbound.UsuarioRepository;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper.IUsuarioMapper;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.entity.UsuarioEntity;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioImplRepository implements UsuarioRepository {

    private final UsuarioJPARepository usuarioJPARepository;
    private final UsuarioFactory factory;
    private final IUsuarioMapper mapper;
    private final MensageriaEventProducer mensagem;

    public UsuarioImplRepository (UsuarioJPARepository usuarioJPARepository, UsuarioFactory factory, IUsuarioMapper mapper, MensageriaEventProducer mensagem) {
        this.usuarioJPARepository =usuarioJPARepository;
        this.factory = factory;
        this.mapper = mapper;
        this.mensagem = mensagem;
    }

    @Override
    public Usuario create(Usuario usuario) {
        var usuarioEntity = mapper.toEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder().encode(usuario.getSenha()));
        usuarioEntity = usuarioJPARepository.save(usuarioEntity);
        var mensagemUsuario = new UsuarioDTO(
                usuarioEntity.getIdUsuario(),
                usuarioEntity.getNome(),
                usuarioEntity.getUsername(),
                usuarioEntity.getPassword(),
                usuarioEntity.getDataNascimento().toString(),
                usuarioEntity.getTipo().toString(),
                usuarioEntity.getCPF(),
                usuarioEntity.getEmail(),
                usuarioEntity.getTell()
        );
        var mensagemEnviada = new HistoricoDTO(
                mensagemUsuario,
                null,
                null,
                null,
                LocalDate.now().toString(),
                "Criando Usuario " + mensagemUsuario.username()
        );
        mensagem.sendHistorico(mensagemEnviada);
        return mapper.toDomain(usuarioEntity);
    }

    @Override
    public Usuario update(Usuario usuario) {
        var entity = usuarioJPARepository.findByUsername(usuario.getUsername());
        entity.setNome(usuario.getNome());
        entity.setSenha(passwordEncoder().encode(usuario.getSenha()));
        entity.setDataNascimento(usuario.getDataNascimento());
        entity.setCPF(usuario.getCPF());
        entity.setTell(usuario.getTell());
        entity.setTipo(usuario.getTipo());
        entity.setEmail(usuario.getEmail());

        var mensagemUsuario = new UsuarioDTO(
                entity.getIdUsuario(),
                entity.getNome(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getDataNascimento().toString(),
                entity.getTipo().toString(),
                entity.getCPF(),
                entity.getEmail(),
                entity.getTell()
        );

        var mensagemEnviada = new HistoricoDTO(
                mensagemUsuario,
                null,
                null,
                null,
                LocalDate.now().toString(),
                "Alterando Usuario " + mensagemUsuario.username()
        );
        mensagem.sendHistorico(mensagemEnviada);
        return mapper.toDomain(usuarioJPARepository.save(entity));
    }

    @Override
    public Usuario findByUsername(String username) {
        return mapper.toDomain(usuarioJPARepository.findByUsername(username));
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioJPARepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(String username) {
        var entity = usuarioJPARepository.findByUsername(username);
        var mensagemUsuario = new UsuarioDTO(
                entity.getIdUsuario(),
                entity.getNome(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getDataNascimento().toString(),
                entity.getTipo().toString(),
                entity.getCPF(),
                entity.getEmail(),
                entity.getTell()
        );

        var mensagemEnviada = new HistoricoDTO(
                mensagemUsuario,
                null,
                null,
                null,
                LocalDate.now().toString(),
                "Deletando Usuario " + mensagemUsuario.username()
        );
        mensagem.sendHistorico(mensagemEnviada);
        usuarioJPARepository.delete(entity);
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
