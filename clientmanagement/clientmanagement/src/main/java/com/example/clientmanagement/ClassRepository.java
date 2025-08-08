package com.example.clientmanagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Client, Long> {
}
