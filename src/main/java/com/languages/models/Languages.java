package com.languages.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "languages")
public class Languages {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@NotNull
	private Long identifier;
	
	@NotNull
	@Size( min = 2, max = 20)
	private String name;

	@NotNull
	@Size( min = 2, max = 20)
	private String creator;
	
	@NotNull
	@Size( max = 50)
	private String currentVersion;
	
	public Languages() {}
	
	public Languages(Long identifier, String name,String creator, String currentVersion) {
		this.identifier = identifier;
		this.creator = creator;
		this.name = name;
		this.currentVersion = currentVersion;
	}
	
	public Languages(String name,String creator, String currentVersion) {
		this.creator = creator;
		this.name = name;
		this.currentVersion = currentVersion;
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	
	
	
	
}
