package com.example.server.repository;

import com.example.server.entity.Destination;
import com.example.server.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByTimeAndDestination(LocalTime time, Destination destination);
}
