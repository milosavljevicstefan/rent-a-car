package com.ftninformatika.rent.service;

import com.ftninformatika.rent.model.Adresa;

import java.util.List;
import java.util.Optional;

public interface AdresaService {

    Optional<Adresa> findOne(Long id);

    List<Adresa> findAll();

    Adresa save(Adresa adresa);

    void delete(Long id);

}
