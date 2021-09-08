package com.ftninformatika.rent.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class NajamDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
    
    @Positive(message = "Id mora biti pozitivan broj.")
    private Long automobilId;
    
    @NotBlank
    private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAutomobilId() {
		return automobilId;
	}

	public void setAutomobilId(Long automobilId) {
		this.automobilId = automobilId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
    
}
