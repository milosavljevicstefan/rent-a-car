package com.ftninformatika.rent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.model.Korisnik;
import com.ftninformatika.rent.model.Najam;
import com.ftninformatika.rent.service.AutomobilService;
import com.ftninformatika.rent.service.KorisnikService;
import com.ftninformatika.rent.service.NajamService;
import com.ftninformatika.rent.support.NajamDtoToNajam;
import com.ftninformatika.rent.support.NajamToNajamDto;
import com.ftninformatika.rent.web.dto.NajamDTO;

@RestController
@RequestMapping(value = "/api/najam", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class NajamController {
	
	@Autowired
	private NajamDtoToNajam toNajam;
	
	@Autowired
	private NajamToNajamDto toDto;
	
	@Autowired
	private NajamService najamService;
	
	@Autowired
	private AutomobilService automobilService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@Valid @RequestBody NajamDTO najamDTO){
		System.out.println("s");
		Najam nn = toNajam.convert(najamDTO);
		Najam n = najamService.action(nn);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
