package com.ftninformatika.rent.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.rent.model.Kompanija;
import com.ftninformatika.rent.web.dto.KompanijaDTO;

@Component
public class KompanijaToKompanijaDto implements Converter<Kompanija, KompanijaDTO> {

	@Override
	public KompanijaDTO convert(Kompanija source) {
		KompanijaDTO dto = new KompanijaDTO();
		
		dto.setAdresa(source.getAdresa());
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setTelefon(source.getTelefon());
		
		return dto; 
	}
	
	public List<KompanijaDTO> convert(List<Kompanija> kompanije) {
		List<KompanijaDTO> dtos = new ArrayList<>();
		
		for (Kompanija k : kompanije)
			dtos.add(convert(k));
		
		return dtos;
	}

}
