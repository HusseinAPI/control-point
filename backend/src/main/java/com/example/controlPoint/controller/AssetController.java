package com.example.controlPoint.controller;
import com.example.controlPoint.model.Asset;
import com.example.controlPoint.service.AssetService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @PostMapping
    public Asset addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }

    @GetMapping
    public List<Asset> getAssets() {
        return assetService.getAssets();
    }

    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id) {
        return assetService.getAssetById(id);
    }
}

