package com.example.controlPoint.service;
import com.example.controlPoint.model.Asset;
import com.example.controlPoint.repository.AssetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    // add new asset
    public Asset addAsset(Asset asset){
      return  assetRepository.save(asset);
    }

    // fetch all assets
    public List<Asset> getAssets(){
     return assetRepository.findAll();
    }


    // get Asset by ID
    public Asset getAssetById(Long id){
        Optional<Asset> optionalAsset = assetRepository.findById(id);
       return optionalAsset.orElseThrow(()-> new RuntimeException("Asset not found"));
    }
}
