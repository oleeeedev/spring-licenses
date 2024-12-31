package dev.ole.spring.controller;

import dev.ole.spring.model.License;
import dev.ole.spring.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/licenses")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping
    public List<License> getAllLicenses() {
        return licenseService.getAllLicenses();
    }

    @GetMapping("/{id}/create")
    public ResponseEntity<License> getLicenseById(@PathVariable String id) {
        Optional<License> license = licenseService.getLicenseById(id);
        return license.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public License createLicense(@RequestBody License license) {
        return licenseService.createLicense(license);
    }

    @GetMapping("/{id}/validate")
    public boolean validateLicense(@PathVariable String id) {
        Optional<License> license = licenseService.getLicenseById(id);
        if (license.isEmpty()) return false;
        return license.map(License::isValid).orElse(false);
    }

    @PutMapping("/{id}")
    public ResponseEntity<License> updateLicense(@PathVariable String id, @RequestBody License license) {
        License updatedLicense = licenseService.updateLicense(id, license);
        return updatedLicense != null ? ResponseEntity.ok(updatedLicense) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLicense(@PathVariable String id) {
        licenseService.deleteLicense(id);
        return ResponseEntity.noContent().build();
    }
}