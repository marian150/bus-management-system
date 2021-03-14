package com.example.server.repository;

import com.example.server.entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Optional<Destination> findByName(String name);
}
