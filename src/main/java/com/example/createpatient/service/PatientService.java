package com.example.createpatient.service;

import com.example.createpatient.entity.HashRequest;
import com.example.createpatient.entity.HashResponse;
import com.example.createpatient.entity.Patient;
import com.example.createpatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class PatientService {
    private final String HASH_SERVICE_URL = "http://localhost:8080/hash";

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Patient createPatient(Patient patient) {
        try {
            HashRequest request = new HashRequest(patient.getPasswordHash());
            HashResponse response = restTemplate.postForObject(HASH_SERVICE_URL, request, HashResponse.class);

            if (response != null) {
                patient.setPasswordHash(response.getHash());
            }
        } catch (Exception e) {
            // Hashing service is not available; save the raw password (not recommended for production!)
            System.err.println("Hashing service unavailable. Saving raw password.");
        }

        return patientRepository.save(patient);
    }

}
