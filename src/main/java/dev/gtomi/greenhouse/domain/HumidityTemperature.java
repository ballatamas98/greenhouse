package dev.gtomi.greenhouse.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "humidity_temperature")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HumidityTemperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private Double humidity;
    @Column
    private Double temperature;
    @Column
    private LocalDateTime date;

}
