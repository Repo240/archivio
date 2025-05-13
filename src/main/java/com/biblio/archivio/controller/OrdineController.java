package com.biblio.archivio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblio.archivio.entity.Cliente;
import com.biblio.archivio.entity.Ordine;
import com.biblio.archivio.service.OrdineService;

@RestController
@RequestMapping("/api")
public class OrdineController {

    @Autowired
    private OrdineService ordineService;

    @PostMapping("/cliente")
    public Cliente creaClienteConOrdini() {
        return ordineService.creaClienteConOrdini();
    }

    @GetMapping("/ordini/{clienteId}")
    public List<Ordine> getOrdini(@PathVariable Long clienteId) {
        return ordineService.getOrdiniByCliente(clienteId);
    }
}
