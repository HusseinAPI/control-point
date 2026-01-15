package com.example.controlPoint.service;
import com.example.controlPoint.model.Asset;
import com.example.controlPoint.repository.AssetRepository;
import com.example.controlPoint.repository.SensorRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.controlPoint.model.SensorReading;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class SensorService {

    private final AssetRepository assetRepository;
    private final SensorRepository sensorRepository;

    public SensorService(AssetRepository assetRepository, SensorRepository sensorRepository) {
        this.assetRepository = assetRepository;
        this.sensorRepository = sensorRepository;
    }

    // View latest sensor reading for specific asset
    public SensorReading viewSensorReading(Long assetId){

        List<SensorReading> sensors = sensorRepository.findByAssetId(assetId);

       if(sensors.isEmpty()){
           throw new RuntimeException("No readings for asset ");
       }

        return sensors.stream().max(Comparator.comparing(SensorReading::getTimestamp)).get();

    }

    // Change sensor reading details for assets after 10 sec
     @Scheduled(fixedRate = 10000)
    public List<SensorReading> changeSenReadDetails(){

        System.out.println("Change Sensor in 10 SEC");
        List<Asset> assets = assetRepository.findAll();
        Random random = new Random();
        String[] status = {"RUNNING","STOPPED","MAINTENANCE"};

        List<SensorReading> updatedSensors = new ArrayList<>();

        for(Asset asset: assets){

            SensorReading sensor = new SensorReading();

            sensor.setAssetId(asset.getId());
            sensor.setTemperature(random.nextInt(90));
            sensor.setPressure(Math.round((random.nextDouble() * 2) * 10) / 10.0);
            sensor.setTimestamp(LocalDateTime.now());
            asset.setStatus(status[random.nextInt(3)]);

            assetRepository.save(asset);
            sensorRepository.save(sensor);

            updatedSensors.add(sensor);

        }
        return updatedSensors;
    }

}
