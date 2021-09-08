package com.ftninformatika.rent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.rent.model.Kompanija;

@Repository
public interface KompanijaRepository extends JpaRepository<Kompanija, Long> {

	
}
