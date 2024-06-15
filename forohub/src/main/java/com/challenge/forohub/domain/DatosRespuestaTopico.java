package com.challenge.forohub.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public record DatosRespuestaTopico(
                                     Long id,
                                     String titulo,
                                     String mensaje,
                                     String fechaCreacion,
                                     String status,
                                     String autor,
                                     String curso)
                                    {
}
