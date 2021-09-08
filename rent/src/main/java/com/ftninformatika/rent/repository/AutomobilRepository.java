package com.ftninformatika.rent.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.rent.model.Automobil;

@Repository
public interface AutomobilRepository extends JpaRepository<Automobil, Long> {

	Page<Automobil> findByModelIgnoreCaseContains(String model, Pageable page);
}
