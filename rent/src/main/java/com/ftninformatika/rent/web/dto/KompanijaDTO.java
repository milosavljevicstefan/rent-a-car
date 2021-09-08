package com.ftninformatika.rent.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class KompanijaDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
    
    @NotBlank
    private String naziv;
    
    @NotBlank
    private String adresa;
    
    @NotBlank
    private String telefon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
