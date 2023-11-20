package dev.gtomi.greenhouse.repository;


import dev.gtomi.greenhouse.domain.HumidityTemperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumidityTemperatureRepository extends JpaRepository<HumidityTemperature, Long> {


    @Query(value = "select * from humidity_temperature as ht where CAST( ht.date AS DATE ) = CURDATE() ", nativeQuery = true)
    List<HumidityTemperature> findByDateToday();

    @Query(value = "select * from humidity_temperature as ht where CAST( ht.date AS DATE ) = subdate(curdate(), 1) ", nativeQuery = true)
    List<HumidityTemperature> findByDateYesterday();

    @Query(value = "select * from humidity_temperature as ht where CAST( ht.date AS DATE ) between subdate(curdate(), 7) and subdate(curdate(), 1) ", nativeQuery = true)
    List<HumidityTemperature> findByDatePastWeek();
}
