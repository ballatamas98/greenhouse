package dev.gtomi.greenhouse.service;

import dev.gtomi.greenhouse.domain.DTO.HumidityTemperatureData;
import dev.gtomi.greenhouse.domain.DTO.HumidityTemperatureFormItem;
import dev.gtomi.greenhouse.domain.HumidityTemperature;
import dev.gtomi.greenhouse.domain.Sensor;
import dev.gtomi.greenhouse.repository.HumidityTemperatureRepository;
import dev.gtomi.greenhouse.repository.SensorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HumidityTemperatureService {

    private final HumidityTemperatureRepository humidityTemperatureRepository;
    private final SensorRepository sensorRepository;


    public List<HumidityTemperatureData> getHumidityTemperatureDataList(String period) {

        return switch (period) {
            case "today" ->
                    humidityTemperatureRepository.findByDateToday().stream().map(HumidityTemperatureData::new).toList();
            case "yesterday" ->
                    humidityTemperatureRepository.findByDateYesterday().stream().map(HumidityTemperatureData::new).toList();
            case "past-week" ->
                    humidityTemperatureRepository.findByDatePastWeek().stream().map(HumidityTemperatureData::new).toList();
            default -> throw new IllegalArgumentException();
        };

    }

    public void save(HumidityTemperatureFormItem humidityTemperatureFormItem) {
        Sensor sensor= sensorRepository.findByIp(humidityTemperatureFormItem.getIp()).orElse(null);

        HumidityTemperature humidityTemperature = HumidityTemperature.builder()
                .humidity(humidityTemperatureFormItem.getHumidity()).date(LocalDateTime.now())
                .temperature(humidityTemperatureFormItem.getTemperature()).sensor(sensor).build();

         humidityTemperatureRepository.save(humidityTemperature);
    }
}
