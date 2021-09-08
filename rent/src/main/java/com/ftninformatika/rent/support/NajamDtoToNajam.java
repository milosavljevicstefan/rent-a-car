package com.ftninformatika.rent.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.rent.model.Najam;
import com.ftninformatika.rent.service.AutomobilService;
import com.ftninformatika.rent.service.KorisnikService;
import com.ftninformatika.rent.service.NajamService;
import com.ftninformatika.rent.web.dto.NajamDTO;

@Component
public class NajamDtoToNajam implements Converter<NajamDTO, Najam> {
	
	@Autowired
	private NajamService najamService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private AutomobilService automobilService;

	@Override
	public Najam convert(NajamDTO source) {
		Najam n;
		
		if (source.getId() == null) {
			n = new Najam();
		} else {
			n = najamService.findOne(source.getId());
		}
		
		if (n != null) {
			n.setAutomobil(automobilService.findOne(source.getAutomobilId()));
			n.setId(source.getId());
			n.setKorisnik(korisnikService.findOneByUsername(source.getUsername()));
		}
		
		return n;
	}

}
