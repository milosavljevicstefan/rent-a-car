package com.ftninformatika.rent.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.rent.model.Automobil;
import com.ftninformatika.rent.service.AutomobilService;
import com.ftninformatika.rent.support.AutomobilDtoToAutomobil;
import com.ftninformatika.rent.support.AutomobilToAutomobilDto;
import com.ftninformatika.rent.web.dto.AutomobilDTO;

@RestController
@RequestMapping(value = "/api/automobili", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutomobilController {
	
	@Autowired
	private AutomobilService automobilService;
	
	@Autowired
	private AutomobilToAutomobilDto toDto;
	
	@Autowired
	private AutomobilDtoToAutomobil toAutomobil;
	
	@PreAuthorize("permitAll()")
	@GetMapping("/{id}")
    public ResponseEntity<AutomobilDTO> getOne(@PathVariable Long id){
        Automobil a = automobilService.findOne(id);

        if(a != null) {
            return new ResponseEntity<>(toDto.convert(a), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PreAuthorize("permitAll()")
	@GetMapping
    public ResponseEntity<List<AutomobilDTO>> getAll(
    		@RequestParam(defaultValue = "") String model,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

        Page<Automobil> page = automobilService.find(model, pageNo);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toDto.convert(page.getContent()),headers, HttpStatus.OK);
    }
	
	@PreAuthorize("permitAll()")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AutomobilDTO> create(@Valid @RequestBody AutomobilDTO automobilDTO){
        Automobil auto = toAutomobil.convert(automobilDTO);
        Automobil sacuvan = automobilService.save(auto);

        return new ResponseEntity<>(toDto.convert(sacuvan), HttpStatus.CREATED);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutomobilDTO> update(@PathVariable Long id, @Valid @RequestBody AutomobilDTO automobilDTO){

        if(!id.equals(automobilDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Automobil auto = toAutomobil.convert(automobilDTO);
        Automobil sacuvan = automobilService.save(auto);

        return new ResponseEntity<>(toDto.convert(sacuvan),HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
		Automobil a = automobilService.findOne(id);
		automobilService.delete(id);

        if(a != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
}
