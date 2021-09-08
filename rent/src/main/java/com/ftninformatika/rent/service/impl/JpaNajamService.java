package com.ftninformatika.rent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.model.Najam;
import com.ftninformatika.rent.repository.NajamRepository;
import com.ftninformatika.rent.service.AutomobilService;
import com.ftninformatika.rent.service.NajamService;

@Service
public class JpaNajamService implements NajamService {

	@Autowired
	private NajamRepository najamRepository;
	
	@Autowired
	private AutomobilService automobilService;
	
	@Override
	public Najam findOne(Long id) {
		return najamRepository.findById(id).get();
	}

	@Override
	public Najam action(Najam najam) {
		Automobil a = najam.getAutomobil();
		if (!a.isIznajmljen()) {
			a.setIznajmljen(true);
			return najamRepository.save(najam);
		}
		
		return null;
	}

}
