package br.com.fiap.hospital.usuario.infra.adapter.gateway;

import br.com.fiap.hospital.usuario.application.domain.Usuario;
import br.com.fiap.hospital.usuario.application.domain.UsuarioFactory;
import br.com.fiap.hospital.usuario.application.useCase.outbound.UsuarioRepository;
import br.com.fiap.hospital.usuario.infra.adapter.inbound.mapper.IUsuarioMapper;
import br.com.fiap.hospital.usuario.infra.adapter.outbound.persistent.repository.UsuarioJPARepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioImplRepository implements UsuarioRepository {

    private final UsuarioJPARepository usuarioJPARepository;
    private final UsuarioFactory factory;
    private final IUsuarioMapper mapper;

    public UsuarioImplRepository (UsuarioJPARepository usuarioJPARepository, UsuarioFactory factory, IUsuarioMapper mapper) {
        this.usuarioJPARepository =usuarioJPARepository;
        this.factory = factory;
        this.mapper = mapper;
    }

    @Override
    public Usuario create(Usuario usuario) {
        return mapper.toDomain(usuarioJPARepository.save(mapper.toEntity(usuario)));
    }

    @Override
    public Usuario update(Usuario usuario) {
        var entity = usuarioJPARepository.findByUsername(usuario.getUsername());
        entity.setNome(usuario.getNome());
        entity.setSenha(usuario.getSenha());
        entity.setDataNascimento(usuario.getDataNascimento());
        entity.setCPF(usuario.getCPF());
        entity.setTell(usuario.getTell());
        entity.setTipo(usuario.getTipo());
        entity.setEmail(usuario.getEmail());
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
        usuarioJPARepository.delete(entity);
    }
}
