package dev.gtomi.greenhouse.service;

import dev.gtomi.greenhouse.domain.DTO.HumidityTemperatureData;
import dev.gtomi.greenhouse.repository.HumidityTemperatureRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class HumidityTemperatureService {

    private final HumidityTemperatureRepository humidityTemperatureRepository;


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
}
