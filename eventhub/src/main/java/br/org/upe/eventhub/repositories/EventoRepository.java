package br.org.upe.eventhub.repositories;

import br.org.upe.eventhub.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository <Evento, Integer> {
    public List<Evento> findByTituloContaining(String titulo);
    public List<Evento> findByTituloLike(String titulo);
}
