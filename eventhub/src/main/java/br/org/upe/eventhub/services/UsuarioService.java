package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.exceptions.UsuarioExistenteException;

import java.util.List;

public interface UsuarioService {

    public Usuario cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException;
    public Usuario atualizarUsuario(Usuario usuario);
    public void removerUsuario(int id);
    public List<Usuario> listarUsuarios();
    public Usuario buscarUsuarioPorId(Integer id);
    public Usuario buscarUsuarioPorEmail(String email);
    public Usuario buscarUsuarioPorEmailESenha(String email, String senha);
    public Usuario buscarUsuarioPorLoginESenha(String login, String senha);
}
