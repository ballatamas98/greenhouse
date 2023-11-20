package dev.gtomi.greenhouse.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sensore")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String ip;

    @OneToMany(mappedBy = "sensor", orphanRemoval = true)
    @Nullable
    private List<HumidityTemperature> humidityTemperatures = new ArrayList<>();


}
