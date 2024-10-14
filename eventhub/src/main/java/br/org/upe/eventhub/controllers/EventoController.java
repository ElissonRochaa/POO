package br.org.upe.eventhub.controllers;

import br.org.upe.eventhub.entities.Evento;
import br.org.upe.eventhub.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping()
    public ResponseEntity<Page<Evento>> buscarTodos(Pageable pageable){
        Page<Evento> eventos = eventoService.listarEventos(pageable);
        return ResponseEntity.ok(eventos);
    }

//    @GetMapping("/buscar-todos")
//    public ResponseEntity<List<Evento>> buscarTodos(@RequestParam boolean sort){
//        //Page<Evento> eventos = eventoService.listarEventos(pageable);
//        //return ResponseEntity.ok(eventos);
//    }

    //retornar um evento especifico
    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable int id){
        Evento evento = eventoService.buscarEventoPorId(id);
        if(evento != null){
            //return ResponseEntity.ok(evento);
            //return ResponseEntity.status(HttpStatus.OK).body(evento);
            return ResponseEntity.status(200).body(evento);
        }
        return ResponseEntity.notFound().build();
    }

}
