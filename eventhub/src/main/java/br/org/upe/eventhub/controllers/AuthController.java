package br.org.upe.eventhub.controllers;

import br.org.upe.eventhub.entities.DTO.LoginDTO;
import br.org.upe.eventhub.entities.DTO.UsuarioDTO;
import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.entities.enums.PerfilEnum;
import br.org.upe.eventhub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDTO loginDTO) {
        Usuario usuario = usuarioService.buscarUsuarioPorEmailESenha(loginDTO.email(), loginDTO.senha());
        if(usuario != null) {
            return true;
        }
        return false;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.nome(),
                usuarioDTO.cpf(), usuarioDTO.email(),
                usuarioDTO.senha(), usuarioDTO.telefone());

        usuario.setPerfil(PerfilEnum.PARTICIPANTE);
        usuario.setAtivo(true);

        usuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/register/admin")
    public ResponseEntity registerAdmin(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.nome(),
                usuarioDTO.cpf(), usuarioDTO.email(),
                usuarioDTO.senha(), usuarioDTO.telefone());

        usuario.setPerfil(PerfilEnum.ADMINISTRADOR);
        usuario.setAtivo(true);

        usuario = usuarioService.cadastrarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }


}
