package br.org.upe.eventhub.repositories;

import br.org.upe.eventhub.entities.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
