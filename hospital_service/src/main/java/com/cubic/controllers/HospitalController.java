package com.cubic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.dtos.PatientDto;
import com.cubic.entities.PatientEntity;
import com.cubic.services.HospitalService;

@RestController
@RequestMapping("/patient")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping(value="")
	public PatientDto getAllPatient() {
		
		return hospitalService.savePatient();
		
	}
	
	@PostMapping(value="/check")
	public void savePatientInfo(@RequestBody PatientDto patients) {
		hospitalService.savePatients(patients);
	}
	
	@GetMapping(value="/search/{id}")
	public PatientEntity getPatient(@PathVariable("id") Long id) {
		return hospitalService.findPatient(id);
	}

}
