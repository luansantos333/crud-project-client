package com.projeto.client.controller;

import com.projeto.client.dto.ClientDTO;
import com.projeto.client.service.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable(value = "id") Long id) {
        ClientDTO dto = clientService.findById(id);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll (Pageable p) {
        return ResponseEntity.ok(clientService.findAll(p));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient (@Valid @RequestBody ClientDTO c) {

        ClientDTO dto = clientService.addNewClient(c);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ClientDTO> updateClientById (@PathVariable (value = "id") Long id, @Valid @RequestBody ClientDTO clientDTO) {
        ClientDTO updateClient = clientService.updateClient(id, clientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(updateClient);

    }

    @DeleteMapping ("/{id}")
    public void deleteClientById (@PathVariable (value = "id") Long id) {
        clientService.deleteClient(id);
    }

}
