package com.ftninformatika.rent.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.rent.model.Najam;
import com.ftninformatika.rent.service.NajamService;
import com.ftninformatika.rent.web.dto.NajamDTO;

@Component
public class NajamToNajamDto implements Converter<Najam, NajamDTO> {

	@Override
	public NajamDTO convert(Najam source) {
		NajamDTO dto = new NajamDTO();
		
		dto.setAutomobilId(source.getAutomobil().getId());
		dto.setId(source.getId());
		dto.setUsername(source.getKorisnik().getKorisnickoIme());
		
		return dto;
	}
	

}
