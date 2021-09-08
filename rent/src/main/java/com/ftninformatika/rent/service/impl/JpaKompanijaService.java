package com.ftninformatika.rent.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.model.Kompanija;
import com.ftninformatika.rent.repository.KompanijaRepository;
import com.ftninformatika.rent.service.KompanijaService;

@Service
@Primary
public class JpaKompanijaService implements KompanijaService {

	@Autowired
	private KompanijaRepository kompanijaRepository;
	
	@Override
	public List<Kompanija> findAll() {
		return kompanijaRepository.findAll();
	}

	@Override
	public Kompanija findOne(Long id) {
		return kompanijaRepository.getOne(id);
	}

	@Override
	public List<Automobil> findAllAutomobil(Long id) {
		Kompanija k = kompanijaRepository.getOne(id);
		List<Automobil> retVal = k.getAutomobili();
		return retVal;
	}

	@Override
	public Kompanija update(Kompanija kompanija) {
		return kompanijaRepository.save(kompanija);
	}

}
