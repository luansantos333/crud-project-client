package com.projeto.client.service;

import com.projeto.client.dto.ClientDTO;
import com.projeto.client.repository.ClientRepo;
import com.projeto.client.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Transactional (readOnly = true)
    public ClientDTO findById (Long id) {
       ClientDTO dto = new ClientDTO(clientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found the client with the specified id")));
        return dto;
    }




}
