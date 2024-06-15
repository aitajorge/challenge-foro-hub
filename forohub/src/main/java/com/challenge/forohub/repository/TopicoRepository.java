package com.challenge.forohub.repository;

import com.challenge.forohub.domain.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTitulo(String titulo);
    Optional<Topico> findByMensaje(String mensaje);

    @Query("SELECT t FROM Topico t WHERE t.status = 'activo'")
    Page<Topico> findAllActive(Pageable pageable);
}

