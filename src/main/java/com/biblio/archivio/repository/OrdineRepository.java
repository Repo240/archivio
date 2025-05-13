package com.biblio.archivio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblio.archivio.entity.Ordine;

@Repository
public interface OrdineRepository extends JpaRepository<Ordine, Long> {

    // Trova tutti gli ordini di un cliente specifico
    List<Ordine> findByClienteId(Long clienteId);
}