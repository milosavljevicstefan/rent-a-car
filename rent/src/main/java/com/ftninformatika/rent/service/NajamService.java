package com.ftninformatika.rent.service;

import com.ftninformatika.rent.model.Najam;

public interface NajamService {

	Najam findOne(Long id);
	
	Najam action(Najam najam);
}
