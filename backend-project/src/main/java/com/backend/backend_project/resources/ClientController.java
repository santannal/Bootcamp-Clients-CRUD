package com.backend.backend_project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.backend_project.dto.ClientRequest;
import com.backend.backend_project.dto.ClientResponse;
import com.backend.backend_project.services.ClientService;

// import io.micrometer.core.ipc.http.HttpSender.Response;
// import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> save(@Validated @RequestBody ClientRequest clientRequest) {
        ClientResponse clientResponse = clientService.save(clientRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(clientResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientResponse> getClient(@PathVariable long id) {
        ClientResponse clientResponse = clientService.getById(id);
        return ResponseEntity.ok(clientResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getClients() {
        return ResponseEntity.ok(clientService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeClient(@PathVariable long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateClient(@PathVariable long id, @RequestBody ClientRequest clientUpdate) {
        clientService.update(id, clientUpdate);
        return ResponseEntity.ok().build();
    }
}
