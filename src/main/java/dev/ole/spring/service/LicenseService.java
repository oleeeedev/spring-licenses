package dev.ole.spring.service;

import dev.ole.spring.model.License;
import dev.ole.spring.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    public List<License> getAllLicenses() {
        return licenseRepository.findAll();
    }

    public Optional<License> getLicenseById(String id) {
        return licenseRepository.findById(id);
    }

    public License createLicense(License license) {
        return licenseRepository.save(license);
    }

    public License updateLicense(String id, License license) {
        if (licenseRepository.existsById(id)) {
            license.setId(id);
            return licenseRepository.save(license);
        }
        return null;
    }

    public void deleteLicense(String id) {
        licenseRepository.deleteById(id);
    }
}
