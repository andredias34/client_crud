package com.dvsuperior.cliente.services;

import com.dvsuperior.cliente.dto.ClientDTO;
import com.dvsuperior.cliente.entities.Client;
import com.dvsuperior.cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public List<ClientDTO> findAll(){
        List<Client> result = repository.findAll();
        return result.stream().map(x -> new ClientDTO(x)).toList();
    }
}







































