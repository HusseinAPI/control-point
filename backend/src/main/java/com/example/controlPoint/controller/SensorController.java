package com.example.controlPoint.controller;
import com.example.controlPoint.model.SensorReading;
import com.example.controlPoint.service.SensorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")

public class SensorController{

    private final SensorService sensorService;
    public SensorController(SensorService sensorService){
    this.sensorService = sensorService ;
}

    @GetMapping("/{assetId}")
    public SensorReading viewSensorReading(@PathVariable Long assetId){
        return sensorService.viewSensorReading(assetId);

    }
}
