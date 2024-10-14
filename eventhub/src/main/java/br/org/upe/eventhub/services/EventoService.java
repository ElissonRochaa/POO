package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EventoService {
    public Evento cadastrarEvento(Evento evento);
    public Page<Evento> listarEventos(Pageable pageable);
    public Evento buscarEventoPorId(int id);
    public List<Evento> buscarEventoPorTituloContaining(String titulo);
    public List<Evento> buscarEventoPorInicioTitulo(String titulo);
}
