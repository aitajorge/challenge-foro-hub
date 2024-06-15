package com.challenge.forohub.controller;

import com.challenge.forohub.domain.DatosRespuestaTopico;
import com.challenge.forohub.domain.Topico;
import com.challenge.forohub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private PagedResourcesAssembler<Topico> pagedResourcesAssembler;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRespuestaTopico datosRegistrarTopico) {
        if (topicoRepository.findByTitulo(datosRegistrarTopico.titulo()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El título ya existe");
        }

        if (topicoRepository.findByMensaje(datosRegistrarTopico.mensaje()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El mensaje ya existe");
        }

        Topico topico = topicoRepository.save(new Topico(datosRegistrarTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(),
                topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(), topico.getAutor(), topico.getCurso());
        // return 201 Created
        // URI donde encontrar el tópico
        // HTTP://localhost:8080/topicos/xx
        return ResponseEntity.status(HttpStatus.CREATED)
            .header("Location","/topicos/"+topico.getId())
                .body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>>  listadoTopicos(Pageable pageable) {
        Page<Topico> topicosActivosPage = topicoRepository.findAllActive(pageable);
        return ResponseEntity.ok(topicosActivosPage.map(DatosListadoTopicos::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),
                topico.getTitulo(),topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(),topico.getAutor(), topico.getCurso()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico(topico);
        return ResponseEntity.noContent().build();

//    public void eliminarTopico(@PathVariable Long id) {
//        Topico topico = topicoRepository.getReferenceById(id);
//        topicoRepository.delete(topico);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosAutor(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosAutor = new DatosRespuestaTopico(topico.getId(),
                topico.getTitulo(),topico.getMensaje(), topico.getFechaCreacion(),
                topico.getStatus(),topico.getAutor(), topico.getCurso());
        return ResponseEntity.ok(datosAutor);
    }
}
