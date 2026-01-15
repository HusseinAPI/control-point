package com.example.controlPoint;
import com.example.controlPoint.model.Asset;
import com.example.controlPoint.model.SensorReading;
import com.example.controlPoint.repository.AssetRepository;
import com.example.controlPoint.repository.SensorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class ControlPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlPointApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(AssetRepository assetRepository, SensorRepository sensorRepository) {
		return args -> {
			// Add Default Assets
			Asset asset1 = assetRepository.save(new Asset("Turbine-01", "Engine", "RUNNING"));
			Asset asset2 = assetRepository.save(new Asset("Pump-01", "Pump", "STOPPED"));
			Asset asset3 = assetRepository.save(new Asset("Valve-01", "Valve", "MAINTENANCE"));

			// Add Default Sensors Reading
			sensorRepository.save(new SensorReading(null, asset1.getId(), 75, 1.2, LocalDateTime.now()));
			sensorRepository.save(new SensorReading(null, asset2.getId(), 60, 1.5, LocalDateTime.now()));
			sensorRepository.save(new SensorReading(null, asset3.getId(), 80, 1.1, LocalDateTime.now()));
		};
	}

}
