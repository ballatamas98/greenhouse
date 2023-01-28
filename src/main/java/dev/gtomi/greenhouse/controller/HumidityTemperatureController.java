package dev.gtomi.greenhouse.controller;

import dev.gtomi.greenhouse.domain.DTO.HumidityTemperatureData;
import dev.gtomi.greenhouse.service.HumidityTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/humidity-temperatures")
public class HumidityTemperatureController {

    private HumidityTemperatureService humidityTemperatureService;

    @Autowired
    public HumidityTemperatureController(HumidityTemperatureService humidityTemperatureService) {
        this.humidityTemperatureService = humidityTemperatureService;
    }


    @GetMapping("/get-data/{period}")
    public ResponseEntity<List<HumidityTemperatureData>> getPostList(@PathVariable("period") String period) {
        return new ResponseEntity<>(humidityTemperatureService.getHumidityTemperatureDataList(period), HttpStatus.OK);
    }
}
