package dev.ole.spring.repository;

import dev.ole.spring.model.License;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LicenseRepository extends MongoRepository<License, String> {
}
