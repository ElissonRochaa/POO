package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Evento;
import br.org.upe.eventhub.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Evento cadastrarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public Page<Evento> listarEventos(Pageable pageable) {
        return eventoRepository.findAll(pageable);
    }

    @Override
    public Evento buscarEventoPorId(int id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evento> buscarEventoPorTituloContaining(String titulo) {
        return eventoRepository.findByTituloContaining(titulo);
    }

    public List<Evento> buscarEventoPorInicioTitulo(String titulo){
        return eventoRepository.findByTituloLike('%'+titulo+'%');
    }
}
