package com.college.labassetmanager.repository.service;

import com.college.labassetmanager.model.Asset;
import com.college.labassetmanager.model.Asset.Status; // Import the enum
import com.college.labassetmanager.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset saveAsset(Asset asset) {
        asset.setStatus(Status.WORKING);  // ✅ Use enum instead of String
        asset.setType("Desktop");         // Assuming type is a String
        return assetRepository.save(asset);
    }

    public void deleteAsset(Integer id) {
        Asset asset = assetRepository.findById(id).orElseThrow();
        asset.setStatus(Status.DELETED);  // ✅ Use enum instead of String
        assetRepository.save(asset);
    }
}
