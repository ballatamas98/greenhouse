package dev.gtomi.greenhouse.domain;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "humidity_temperature")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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


    @ManyToOne
    @JoinColumn(name = "sensor_id")
    @Nullable
    private Sensor sensor;

}
