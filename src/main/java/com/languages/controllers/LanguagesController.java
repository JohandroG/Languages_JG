package com.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.languages.models.Languages;
import com.languages.services.LanguagesService;


@Controller
public class LanguagesController {
	
	private final LanguagesService langService;

	public LanguagesController(LanguagesService languageservice) {
		this.langService = languageservice;
	}


	
@RequestMapping( value="/", method = RequestMethod.GET )
public String displayLanguages(@ModelAttribute("language") Languages language, Model model) {

	List<Languages> languageList = langService.getAllLanguages();

	model.addAttribute("langList", languageList);
	return "index.jsp";
	
}

//--------------------EDIT INFO------------------------------------------------------------

@RequestMapping( value="/edit/{id}", method = RequestMethod.GET )
public String displayEditInfo(@PathVariable("id") Long id, Model model) {
	
	Languages languageinfo = langService.getLanguagebyID(id);
	
	model.addAttribute("language", languageinfo);
	
	return "edit.jsp";
}
//--------------------INFO--------

@RequestMapping( value="/info/{id}", method = RequestMethod.GET )
public String displayInfo(@PathVariable("id") Long id, Model model) {
	
	Languages languageinfo = langService.getLanguagebyID(id);
	
	model.addAttribute("language", languageinfo);
	
	return "info.jsp";
}

//---------------DELETE-------------

@RequestMapping(value="/delete/{id}", method=RequestMethod.POST)
public String Delete(@PathVariable("id") Long id) {
	langService.deleteLanguage(id);
	return "redirect:/";
}

//-------------------CREATE------------

@RequestMapping(value="/create", method=RequestMethod.POST)
public String createLanguage(@RequestParam(value = "name") String name,
@RequestParam(value = "creator")String creator,
@RequestParam(value = "version")String version) {
	
	
	
	Languages newlang = new Languages(name,creator,version);
	langService.createlang(newlang);
	return "redirect:/";
	
}




//-----------------UPDATE--------------
@RequestMapping(value="/update", method=RequestMethod.POST)
public String updateLanguage(@RequestParam(value = "id") Long id,
@RequestParam(value = "name") String name,
@RequestParam(value = "creator")String creator,
@RequestParam(value = "version")String version){
	
	Languages editedlang = new Languages(id,name,creator,version);
	
		langService.updatelang(editedlang);
		return "redirect:/";
}

}



