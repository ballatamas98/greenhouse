package dev.gtomi.greenhouse.domain.DTO;

import dev.gtomi.greenhouse.config.SpringWebConfig;
import dev.gtomi.greenhouse.domain.HumidityTemperature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HumidityTemperatureData {
    private Double humidity;
    private Double temperature;
    private String date;

    public HumidityTemperatureData(HumidityTemperature humidityTemperature) {
        this.humidity = humidityTemperature.getHumidity();
        this.temperature = humidityTemperature.getTemperature();
        this.date = SpringWebConfig.DATE_TIME_FORMATTER.format(humidityTemperature.getDate());
    }
}
