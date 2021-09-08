package com.ftninformatika.rent.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.web.dto.AutomobilDTO;

@Component
public class AutomobilToAutomobilDto implements Converter<Automobil, AutomobilDTO> {

	@Override
	public AutomobilDTO convert(Automobil source) {
		AutomobilDTO dto = new AutomobilDTO();
		
		dto.setGodiste(source.getGodiste());
		dto.setId(source.getId());
		dto.setIznajmljen(source.isIznajmljen());
		dto.setKompanijaId(source.getKompanija().getId());
		dto.setKompanijaNaziv(source.getKompanija().getNaziv());
		dto.setModel(source.getModel());
		dto.setPotrosnja(source.getPotrosnja());
		dto.setRegistracija(source.getRegistracija());
		
		return dto;
	}
	
	public List<AutomobilDTO> convert(List<Automobil> automobili) {
		
		List<AutomobilDTO> dtos = new ArrayList<>();
		
		for (Automobil a: automobili)
			dtos.add(convert(a));
		
		return dtos;
	}
}
