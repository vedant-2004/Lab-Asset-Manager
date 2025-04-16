package com.college.labassetmanager.repository;

import com.college.labassetmanager.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
