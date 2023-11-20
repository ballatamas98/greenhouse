package dev.gtomi.greenhouse.repository;

import dev.gtomi.greenhouse.domain.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    Optional<Sensor> findByIp(String ip);
}