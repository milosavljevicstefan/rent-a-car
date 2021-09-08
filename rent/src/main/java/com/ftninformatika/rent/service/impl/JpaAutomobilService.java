package com.ftninformatika.rent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.model.Kompanija;
import com.ftninformatika.rent.repository.AutomobilRepository;
import com.ftninformatika.rent.service.AutomobilService;
import com.ftninformatika.rent.service.KompanijaService;

@Service
public class JpaAutomobilService implements AutomobilService {

	@Autowired
	private AutomobilRepository automobilRepository;
	
	@Autowired
	private KompanijaService kompanijaService;
	
	@Override
	public Automobil findOne(Long id) {
		return automobilRepository.findById(id).get();
	}

	@Override
	public List<Automobil> findAll() {
		return automobilRepository.findAll();
	}

	@Override
	public Automobil save(Automobil automobil) {
		return automobilRepository.save(automobil);
	}

	@Override
	public void delete(Long id) {
		Automobil a = automobilRepository.getOne(id);
		Kompanija k = a.getKompanija();
		k.getAutomobili().remove(a);
		k = kompanijaService.update(k);
		automobilRepository.delete(a);
	}

	@Override
	public Page<Automobil> findAllP(int pageNo) {
		return automobilRepository.findAll(PageRequest.of(pageNo, 4));
	}

	@Override
	public Page<Automobil> find(String model, int pageNo) {
		return automobilRepository.findByModelIgnoreCaseContains(model, PageRequest.of(pageNo, 4));
	}

}
