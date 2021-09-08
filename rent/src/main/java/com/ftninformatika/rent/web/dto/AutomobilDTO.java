package com.ftninformatika.rent.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class AutomobilDTO {
	
    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
    
    @NotBlank
    private String model;
    
    @NotBlank
    private String registracija;
    
    private int godiste;
    
    private double potrosnja;
    
    private boolean iznajmljen;
    
    @Positive(message = "Id mora biti pozitivan broj.")
    private Long kompanijaId;
    
    @NotBlank
    private String kompanijaNaziv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistracija() {
		return registracija;
	}

	public void setRegistracija(String registracija) {
		this.registracija = registracija;
	}

	public int getGodiste() {
		return godiste;
	}

	public void setGodiste(int godiste) {
		this.godiste = godiste;
	}

	public double getPotrosnja() {
		return potrosnja;
	}

	public void setPotrosnja(double potrosnja) {
		this.potrosnja = potrosnja;
	}

	public boolean isIznajmljen() {
		return iznajmljen;
	}

	public void setIznajmljen(boolean iznajmljen) {
		this.iznajmljen = iznajmljen;
	}

	public Long getKompanijaId() {
		return kompanijaId;
	}

	public void setKompanijaId(Long kompanijaId) {
		this.kompanijaId = kompanijaId;
	}

	public String getKompanijaNaziv() {
		return kompanijaNaziv;
	}

	public void setKompanijaNaziv(String kompanijaNaziv) {
		this.kompanijaNaziv = kompanijaNaziv;
	}
    
}
