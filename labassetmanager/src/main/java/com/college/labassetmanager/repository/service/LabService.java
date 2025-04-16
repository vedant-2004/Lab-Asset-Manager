package com.college.labassetmanager.repository.service;

import com.college.labassetmanager.model.Lab;
import com.college.labassetmanager.repository.LabRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabService {

    private final LabRepository labRepository;

    public List<Lab> getAllLabs() {
        return labRepository.findAll();
    }

    public Lab getLabById(Long id) {
        return labRepository.findById(id).orElse(null);
    }

    public Lab saveLab(Lab lab) {
        return labRepository.save(lab);
    }

    public void deleteLab(Long id) {
        labRepository.deleteById(id);
    }
}
