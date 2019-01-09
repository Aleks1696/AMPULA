package com.service.core.dao;

import com.service.core.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    
    Patient findByNameAndSurnameEquals(String name, String surname);
    
}
