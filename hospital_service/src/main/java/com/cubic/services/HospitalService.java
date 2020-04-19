package com.cubic.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.dtos.PatientDto;
import com.cubic.entities.PatientEntity;
import com.cubic.repositories.PatientRepository;

@Service
public class HospitalService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	public PatientDto savePatient() {
		
		PatientDto pd = new PatientDto();
		pd.setName("Sagar Ghale");
		pd.setAddress("1010 Jefferys ct");
		pd.setPhoneNo("2524359987");
		pd.setStarted_date("12/02/2020");
		
		return pd;
		
		
	}
	
	public void savePatients(PatientDto patientDto) {
		
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setName(patientDto.getName());
		patientEntity.setAddress(patientDto.getAddress());
		patientEntity.setPhoneNo(patientDto.getPhoneNo());
		patientEntity.setStarted_date(patientDto.getStarted_date());
		patientEntity.setUuid(UUID.randomUUID().toString());
		
		patientRepository.save(patientEntity);
	}

	public PatientEntity findPatient(Long id) {
		
		return patientRepository.getPatients(id);
	}

}
