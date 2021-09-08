package com.ftninformatika.rent.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.rent.model.Kompanija;
import com.ftninformatika.rent.service.KompanijaService;
import com.ftninformatika.rent.web.dto.KompanijaDTO;

@Component
public class KompanijaDtoToKompanija implements Converter<KompanijaDTO, Kompanija> {

	@Autowired
	private KompanijaService kompanijaService;
	
	@Override
	public Kompanija convert(KompanijaDTO source) {
		Kompanija kompanija;
		
		if (source.getId() == null) {
			kompanija = new Kompanija();
		} else {
			kompanija = kompanijaService.findOne(source.getId());
		}
		
		if(kompanija != null) {
			kompanija.setAdresa(source.getAdresa());
			kompanija.setNaziv(source.getNaziv());
			kompanija.setTelefon(source.getTelefon());
		}
		
		return kompanija;
	}
	

}
