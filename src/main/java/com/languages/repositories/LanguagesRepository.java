package com.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.languages.models.Languages;

public interface LanguagesRepository extends Repository <Languages,Long> {
	
	List<Languages> findAll(); //SELECT * FROM ...
	
	Optional<Languages> findByIdentifier( Long id ); // SELECT * FROM ... WHERE id = X

	void deleteById(Long id);

	Languages save(Languages language);
}
