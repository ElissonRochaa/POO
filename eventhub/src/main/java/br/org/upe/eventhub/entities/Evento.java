package br.org.upe.eventhub.entities;

import br.org.upe.eventhub.entities.enums.EventoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "event")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descricao;
    private int capacidade;
    private String local;
    @Enumerated(EnumType.STRING)
    private EventoEnum tipoEvento;
    private LocalDate data;
    private LocalTime hora;
    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Usuario admin;
    @OneToMany(mappedBy = "evento")
    private List<Inscricao> inscricoes;
}
