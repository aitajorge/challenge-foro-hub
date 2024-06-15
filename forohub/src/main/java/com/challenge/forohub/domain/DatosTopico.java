package com.challenge.forohub.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(@NotBlank(message = "El título es obligatorio") String titulo,
                          @NotBlank(message = "El mensaje es obligatorio") String mensaje,
                          @NotBlank  String fechaCreacion,
                          @NotBlank String status,
                          @NotBlank  String autor,
                          @NotBlank String curso) {

}