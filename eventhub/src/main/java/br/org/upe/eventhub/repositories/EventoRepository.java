package br.org.upe.eventhub.repositories;

import br.org.upe.eventhub.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository <Evento, Integer> {
}
