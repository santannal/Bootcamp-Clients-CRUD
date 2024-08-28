package com.backend.backend_project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.backend.backend_project.dto.ClientRequest;
import com.backend.backend_project.dto.ClientResponse;
import com.backend.backend_project.models.Client;
import com.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientResponse getById(long id) {
        Client cli = clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client Not Found"));

        return cli.toDTO();
    }

    public List<ClientResponse> getAll() {
        return clientRepository.findAll().stream.map(c -> c.toDTO())
                .collect(Collectors.toList());
    }

    public ClientResponse save(ClientRequest clientRequest) {
        try {
            Client client = ClientRepository.save(clientRequest.toEntity());
            return client.toDTO();
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Client Save Exception!");
        }
    }

    public void deleteById(long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Client Not Found!");
        }
    }

    public void update(long id, ClientRequest clientUpdate) {

        try {
            Client client = clientRepository.getReferenceById(id);

            client.setGender(clientUpdate.getGender());
            client.setName(clientUpdate.getName());
            client.setSalary(clientUpdate.getSalary());
            client.setBonus(clientUpdate.getBonus());

            clientRepository.save(client);

        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Client Not Found!");
        }

    }
    // TODO demais serviços !!!
}
