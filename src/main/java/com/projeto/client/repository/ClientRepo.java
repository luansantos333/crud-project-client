package com.projeto.client.repository;

import com.projeto.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository <Client, Long> {



}
