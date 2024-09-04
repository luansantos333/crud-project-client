package com.projeto.client.service;

import com.projeto.client.dto.ClientDTO;
import com.projeto.client.model.Client;
import com.projeto.client.repository.ClientRepo;
import com.projeto.client.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        ClientDTO dto = new ClientDTO(clientRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found the client with the specified id")));
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable p) {
        Page<Client> page = clientRepo.findAll(p);
        Page<ClientDTO> map = page.map(ClientDTO::new);
        return map;
    }

    @Transactional
    public ClientDTO addNewClient(ClientDTO clientDTO) {
        Client model = new Client();
        copyDTOToEntity(model, clientDTO);
        clientRepo.save(model);
        return new ClientDTO(model);
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        try {
            Client client = clientRepo.getReferenceById(id);
            copyDTOToEntity(client, clientDTO);
            client = clientRepo.save(client);
            return new ClientDTO(client);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void deleteClient(Long id) {

        if (!clientRepo.existsById(id)) {

            throw new ResourceNotFoundException("Recurso não encontrado");

        }

        clientRepo.deleteById(id);

    }


    private void copyDTOToEntity(Client entity, ClientDTO dto) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setChildren(dto.getChildren());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
    }


}
