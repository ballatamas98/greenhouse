package dev.gtomi.greenhouse.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HumidityTemperatureFormItem {
    private String ip;
    private Double humidity;
    private Double temperature;
}
