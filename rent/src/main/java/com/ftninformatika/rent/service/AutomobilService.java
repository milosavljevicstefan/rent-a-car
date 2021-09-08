package com.ftninformatika.rent.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.rent.model.Automobil;

public interface AutomobilService {

	Automobil findOne(Long id);
	
	List<Automobil> findAll();
	
	Automobil save(Automobil automobil);
	
	void delete(Long id);

	Page<Automobil> findAllP(int pageNo);

	Page<Automobil> find(String model, int pageNo);
}
