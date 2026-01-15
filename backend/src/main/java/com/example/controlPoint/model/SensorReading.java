package com.example.controlPoint.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assetId;
    private int temperature;
    private Double pressure;
    private LocalDateTime timestamp;

    public SensorReading(){}

    public SensorReading(Long id, Long assetId, int temperature, double pressure, LocalDateTime timestamp) {
        this.id = id;
        this.assetId= assetId;
        this.temperature= temperature;
        this.pressure = pressure;
        this.timestamp = timestamp;
    }

    public Long getId(){
        return id;
    }

    public Long getAssetId(){
        return assetId;
    }
    public void setAssetId(Long assetId){
        this.assetId = assetId;
    }

    public int getTemperature(){
        return temperature;
    }
    public void setTemperature(int temperature){
         this.temperature = temperature;
    }

    public Double getPressure(){
        return pressure;
    }
    public void setPressure(Double pressure){
        this.pressure = pressure;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }
}
