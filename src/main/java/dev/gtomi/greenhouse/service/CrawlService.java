package dev.gtomi.greenhouse.service;

import dev.gtomi.greenhouse.domain.HumidityTemperature;
import dev.gtomi.greenhouse.repository.HumidityTemperatureRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class CrawlService {

    private final HumidityTemperatureRepository humidityTemperatureRepository;

    private static String sensorIp;

    public CrawlService(HumidityTemperatureRepository humidityTemperatureRepository) {
        this.humidityTemperatureRepository = humidityTemperatureRepository;
        setSensorIp(sensorIp);
    }

    @Scheduled(cron = "0 0/15 * * * *")
    public void crawlSite() {
        HumidityTemperature humidityTemperature = crawlHumidityAndTemperature();

        humidityTemperatureRepository.save(humidityTemperature);
    }

    private HumidityTemperature crawlHumidityAndTemperature() {
        HumidityTemperature humidityTemperature = new HumidityTemperature();
        humidityTemperature.setDate(LocalDateTime.now());
        humidityTemperature.setTemperature(crawlTemperature());
        humidityTemperature.setHumidity(crawlHumidity());

        return humidityTemperature;
    }

    private static double crawlHumidity() {
        try {
            Document doc = Jsoup.connect(sensorIp).get();
            Element temperatureElement = doc.getElementById("humidity");
            String humidityText = temperatureElement.text();
            return Double.valueOf(humidityText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Double crawlTemperature() {
        try {
            Document doc = Jsoup.connect(sensorIp).get();
            Element temperatureElement = doc.getElementById("temperature");
            String temperatureText = temperatureElement.text();
            return Double.valueOf(temperatureText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Value("${sensor-ip}")
    public void setSensorIp(String sensorIp) {
        CrawlService.sensorIp = sensorIp;
    }
}
