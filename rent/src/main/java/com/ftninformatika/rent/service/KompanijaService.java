package com.ftninformatika.rent.service;

import java.util.List;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.model.Kompanija;

public interface KompanijaService {

	List<Kompanija> findAll();
	
	Kompanija findOne(Long id);
	
	List<Automobil> findAllAutomobil(Long id);
	
	Kompanija update(Kompanija kompanija);
	
}
