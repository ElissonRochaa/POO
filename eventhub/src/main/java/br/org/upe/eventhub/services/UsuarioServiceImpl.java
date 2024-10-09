package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.exceptions.UsuarioExistenteException;
import br.org.upe.eventhub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Usuario cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException{

        Optional<Usuario> usuariobanco = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuariobanco.isPresent()) {
            throw new UsuarioExistenteException();
        }

        Optional<Usuario> usuariobanco2 = usuarioRepository.findByCpf(usuario.getCpf());
        if (usuariobanco2.isPresent()) {
            throw new UsuarioExistenteException();
        }


        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario atualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioBanco = usuarioRepository.findById(usuario.getId());
        if(usuarioBanco.isPresent()) {
            return usuarioRepository.save(usuario);
        }else{
            return null;
        }

    }

    @Override
    public void removerUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
//        Optional<Usuario> usuario = usuarioRepository.findById(id);
//        return usuario.orElse(null);
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha).orElse(null);
    }

    @Override
    public Usuario buscarUsuarioPorLoginESenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha).orElse(null);
    }


}
