package com.challenge.forohub.domain;

import com.challenge.forohub.controller.DatosActualizarTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fechaCreacion;
    private String status;
    private String autor;
    private String curso;

    public Topico(DatosRespuestaTopico datosRespuestaTopico) {
        this.titulo = datosRespuestaTopico.titulo();
        this.mensaje = datosRespuestaTopico.mensaje();
        this.fechaCreacion = datosRespuestaTopico.fechaCreacion();
        this.status = datosRespuestaTopico.status();
        this.autor = datosRespuestaTopico.autor();
        this.curso = datosRespuestaTopico.curso();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }

        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.fechaCreacion() != null) {
            this.fechaCreacion = datosActualizarTopico.fechaCreacion();
        }

        if (datosActualizarTopico.status() != null) {
            this.status = datosActualizarTopico.status();
        }

        if (datosActualizarTopico.autor() != null) {
            this.autor = datosActualizarTopico.autor();
        }

        if (datosActualizarTopico.curso() != null) {
            this.curso = datosActualizarTopico.curso();
        }
    }

    public void desactivarTopico(Topico topico) {
        this.status = "inactivo";
    }
}
