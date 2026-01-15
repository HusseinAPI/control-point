package com.example.controlPoint.repository;
import com.example.controlPoint.model.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository // to indicate this interface interacts with database
public interface SensorRepository extends JpaRepository<SensorReading,Long>{
    List<SensorReading> findByAssetId(Long assetId);
}