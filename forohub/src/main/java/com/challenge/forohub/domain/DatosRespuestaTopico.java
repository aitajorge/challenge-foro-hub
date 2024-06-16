package com.challenge.forohub.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


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
