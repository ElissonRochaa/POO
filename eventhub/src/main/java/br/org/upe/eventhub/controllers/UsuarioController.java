package br.org.upe.eventhub.controllers;

import br.org.upe.eventhub.entities.Usuario;
import br.org.upe.eventhub.exceptions.UsuarioExistenteException;
import br.org.upe.eventhub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

//    @PostMapping
//    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
//        Usuario usuarioCadastrado = usuarioService.cadastrarUsuario(usuario);
//        return ResponseEntity.ok(usuarioCadastrado);
//    }



}
