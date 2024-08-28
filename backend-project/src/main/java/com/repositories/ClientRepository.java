package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.backend_project.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
