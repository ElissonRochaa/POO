package br.org.upe.eventhub.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evento evento;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Usuario usuario;
    private int status;
}
