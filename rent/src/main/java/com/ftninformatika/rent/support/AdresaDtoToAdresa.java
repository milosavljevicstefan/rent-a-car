package com.ftninformatika.rent.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.rent.model.Adresa;
import com.ftninformatika.rent.service.AdresaService;
import com.ftninformatika.rent.web.dto.AdresaDTO;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class AdresaDtoToAdresa implements Converter<AdresaDTO, Adresa> {

    @Autowired
    private AdresaService adresaService;

    @Override
    public Adresa convert(AdresaDTO adresaDto) {
        Adresa entity = null;

        if(adresaDto.getId() == null) {
            entity = new Adresa();
        }else {
            Optional<Adresa> adresaOptional = adresaService.findOne(adresaDto.getId());
            if(adresaOptional.isPresent()){
                entity = adresaOptional.get();
            }
        }

        if(entity != null) {
            entity.setId(adresaDto.getId());
            entity.setBroj(adresaDto.getBroj());
            entity.setUlica(adresaDto.getUlica());
        }

        return entity;
    }

}

