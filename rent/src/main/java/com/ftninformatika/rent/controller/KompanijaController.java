package com.ftninformatika.rent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.model.Kompanija;
import com.ftninformatika.rent.service.KompanijaService;
import com.ftninformatika.rent.support.AutomobilToAutomobilDto;
import com.ftninformatika.rent.support.KompanijaDtoToKompanija;
import com.ftninformatika.rent.support.KompanijaToKompanijaDto;
import com.ftninformatika.rent.web.dto.AutomobilDTO;
import com.ftninformatika.rent.web.dto.KompanijaDTO;

@RestController
@RequestMapping(value = "/api/kompanije", produces = MediaType.APPLICATION_JSON_VALUE)
public class KompanijaController {
	
	@Autowired
	private KompanijaService kompanijaService;
	
	@Autowired
	private AutomobilToAutomobilDto toDtoAuto;
	
	@Autowired
	private KompanijaToKompanijaDto toDto;
	
	@GetMapping("/{id}/automobili")
    public ResponseEntity<List<AutomobilDTO>> getAutomobili(@PathVariable Long id){
        Kompanija k = kompanijaService.findOne(id);
        List<Automobil> a = k.getAutomobili();
        if(a != null) {
            return new ResponseEntity<>(toDtoAuto.convert(a), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@GetMapping("/{id}")
    public ResponseEntity<KompanijaDTO> getOne(@PathVariable Long id){
        Kompanija k = kompanijaService.findOne(id);

        if(k != null) {
            return new ResponseEntity<>(toDto.convert(k), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
    @GetMapping
    public ResponseEntity<List<KompanijaDTO>> getAll(){

    	List<Kompanija> komps = kompanijaService.findAll();

        return new ResponseEntity<>(toDto.convert(komps), HttpStatus.OK);
    
    }
}

