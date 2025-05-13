package com.biblio.archivio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblio.archivio.entity.Cliente;
import com.biblio.archivio.entity.Ordine;
import com.biblio.archivio.repository.ClienteRepository;
import com.biblio.archivio.repository.OrdineRepository;

@Service
public class OrdineService {

    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private OrdineRepository ordineRepo;

    public Cliente creaClienteConOrdini() {
        Cliente cliente = new Cliente();
        cliente.setNome("Mario Rossi");

        Ordine ordine1 = new Ordine();
        ordine1.setDescrizione("Gomma");
        ordine1.setCliente(cliente);

        Ordine ordine2 = new Ordine();
        ordine2.setDescrizione("Matita");
        ordine2.setCliente(cliente);
        
        List<Ordine> ordini =  new ArrayList<Ordine>();
        ordini.add(ordine1);
        ordini.add(ordine2);

        cliente.setOrdini(ordini);

        return clienteRepo.save(cliente); // salva cliente e ordini in cascata
    }

    public List<Ordine> getOrdiniByCliente(Long clienteId) {
        return ordineRepo.findByClienteId(clienteId);
    }
}