package com.challenge.forohub.controller;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarUsuario(
        @NotBlank String nuevoLogin,
        @NotBlank String nuevaClave
) {
}
