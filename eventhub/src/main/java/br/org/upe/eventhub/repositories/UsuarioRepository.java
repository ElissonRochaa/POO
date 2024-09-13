package br.org.upe.eventhub.repositories;

import br.org.upe.eventhub.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

}
