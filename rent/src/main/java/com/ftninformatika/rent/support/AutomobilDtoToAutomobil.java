package com.ftninformatika.rent.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.service.AutomobilService;
import com.ftninformatika.rent.service.KompanijaService;
import com.ftninformatika.rent.web.dto.AutomobilDTO;

@Component
public class AutomobilDtoToAutomobil implements Converter<AutomobilDTO, Automobil> {

	@Autowired
	private AutomobilService automobilService;
	
	@Autowired
	private KompanijaService kompanijaService;
	
	@Override
	public Automobil convert(AutomobilDTO source) {
		Automobil automobil;
		
		if (source.getId() == null) {
			automobil = new Automobil();
		} else {
			automobil = automobilService.findOne(source.getId());
		}
		
		if (automobil != null) {
			automobil.setGodiste(source.getGodiste());
			automobil.setIznajmljen(source.isIznajmljen());
			automobil.setKompanija(kompanijaService.findOne(source.getKompanijaId()));
			automobil.setModel(source.getModel());
			automobil.setPotrosnja(source.getPotrosnja());
			automobil.setRegistracija(source.getRegistracija());
		}
		
		return automobil;
	}
	

}
