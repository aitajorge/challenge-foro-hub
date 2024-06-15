package com.challenge.forohub.controller;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id,
                                    String titulo,
                                    String mensaje,
                                    String fechaCreacion,
                                    String status,
                                    String autor,
                                    String curso) {
}
