package com.example.controlPoint.repository;
import com.example.controlPoint.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // to indicate this interface interacts with database
public interface AssetRepository extends JpaRepository<Asset, Long> {

}
