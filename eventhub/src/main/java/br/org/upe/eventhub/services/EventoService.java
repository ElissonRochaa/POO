package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Evento;

import java.util.List;

public interface EventoService {
    public Evento cadastrarEvento(Evento evento);
    public List<Evento> listarEventos();
    public Evento buscarEventoPorId(int id);
    public List<Evento> buscarEventoPorTituloContaining(String titulo);
    public List<Evento> buscarEventoPorInicioTitulo(String titulo);
}
