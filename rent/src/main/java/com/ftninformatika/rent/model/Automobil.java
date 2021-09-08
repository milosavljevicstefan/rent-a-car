package com.ftninformatika.rent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Automobil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String model;
    
    @Column(nullable = false, unique = true)
    private String registracija;
    
    @Column(nullable = false)
    private int godiste;
    
    @Column
    private double potrosnja;
    
    @Column
    private boolean iznajmljen = false;
    
    @ManyToOne
    private Kompanija kompanija;

	public Automobil() {
		super();
	}

	public Automobil(String model, String registracija, int godiste, double potrosnja, boolean iznajmljen) {
		super();
		this.model = model;
		this.registracija = registracija;
		this.godiste = godiste;
		this.potrosnja = potrosnja;
		this.iznajmljen = iznajmljen;
	}

	public Automobil(Long id, String model, String registracija, int godiste, double potrosnja, boolean iznajmljen) {
		super();
		this.id = id;
		this.model = model;
		this.registracija = registracija;
		this.godiste = godiste;
		this.potrosnja = potrosnja;
		this.iznajmljen = iznajmljen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + godiste;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (iznajmljen ? 1231 : 1237);
		result = prime * result + ((kompanija == null) ? 0 : kompanija.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(potrosnja);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((registracija == null) ? 0 : registracija.hashCode());
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
		Automobil other = (Automobil) obj;
		if (godiste != other.godiste)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (iznajmljen != other.iznajmljen)
			return false;
		if (kompanija == null) {
			if (other.kompanija != null)
				return false;
		} else if (!kompanija.equals(other.kompanija))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(potrosnja) != Double.doubleToLongBits(other.potrosnja))
			return false;
		if (registracija == null) {
			if (other.registracija != null)
				return false;
		} else if (!registracija.equals(other.registracija))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Automobil [id=" + id + ", model=" + model + ", registracija=" + registracija + ", godiste=" + godiste
				+ ", potrosnja=" + potrosnja + ", iznajmljen=" + iznajmljen + ", kompanija=" + kompanija + "]";
	}

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

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}
    
    
}
