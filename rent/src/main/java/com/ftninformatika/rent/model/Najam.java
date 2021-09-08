package com.ftninformatika.rent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Najam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Korisnik korisnik;
	
	@ManyToOne
	private Automobil automobil;

	public Najam() {
		super();
	}

	public Najam(Korisnik korisnik, Automobil automobil) {
		super();
		this.korisnik = korisnik;
		this.automobil = automobil;
	}

	public Najam(Long id, Korisnik korisnik, Automobil automobil) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.automobil = automobil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((automobil == null) ? 0 : automobil.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((korisnik == null) ? 0 : korisnik.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Najam other = (Najam) obj;
		if (automobil == null) {
			if (other.automobil != null)
				return false;
		} else if (!automobil.equals(other.automobil))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Najam [id=" + id + ", korisnik=" + korisnik + ", automobil=" + automobil + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}
	
	
}
