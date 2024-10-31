package br.org.upe.eventhub.controllers;

import br.org.upe.eventhub.entities.DTO.LoginDTO;
import br.org.upe.eventhub.entities.DTO.UsuarioDTO;
import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.entities.enums.PerfilEnum;
import br.org.upe.eventhub.security.TokenService;
import br.org.upe.eventhub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                loginDTO.email(), loginDTO.senha());

        var auth = this.authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok().body(token);
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
