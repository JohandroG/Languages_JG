package com.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.models.Languages;
import com.languages.repositories.LanguagesRepository;

@Service
public class LanguagesService {

	private final LanguagesRepository languagesRepository;
	
//Constructor
	public LanguagesService (LanguagesRepository languageRepository) {
		this.languagesRepository = languageRepository;
	}


	public List<Languages> getAllLanguages(){
		return languagesRepository.findAll();
	}
	
//-------------------------------------------------------------------
	public Languages getLanguagebyID(Long id){
		Optional<Languages> languageByID = languagesRepository.findByIdentifier(id);
		if ( languageByID.isPresent() ) {
			return languageByID.get();
		}
		else {
			return null;
		}
	}
	
	
	public void deleteLanguage(Long id) {
			languagesRepository.deleteById(id);  
	}

	public Languages createlang(Languages language) {
		return languagesRepository.save(language);
	}
	
	public Languages updatelang(Languages language) {
		return languagesRepository.save(language);
	}


	}
