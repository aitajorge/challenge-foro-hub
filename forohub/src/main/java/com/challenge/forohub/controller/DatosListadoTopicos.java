package com.challenge.forohub.controller;

import com.challenge.forohub.domain.Topico;

public record DatosListadoTopicos(Long id,
                                  String titulo,
                                  String mensaje,
                                  String fechaCreacion,
                                  String status,
                                  String autor,
                                  String curso) {
    public DatosListadoTopicos(Topico topico) {

        this(topico.getId(),topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus(),
                topico.getAutor(), topico.getCurso());
    }
}
