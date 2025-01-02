package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table
public class Semestre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "semestre")
    
    private List<Module> modules;

    @OneToMany(mappedBy = "semestre")
    
    private List<Etudiant> etudiants;

	public Semestre() {
		super();
	}

	public Semestre(Long id, String nom, List<Module> modules, List<Etudiant> etudiants) {
		this.id = id;
		this.nom = nom;
		this.modules = modules;
		this.etudiants = etudiants;
	}

	public Semestre(String nom, List<Module> modules, List<Etudiant> etudiants) {
		this.nom = nom;
		this.modules = modules;
		this.etudiants = etudiants;
	}

	
	public Semestre(String nom) {
		super();
		this.nom = nom;
	}

	
	public Semestre(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
    
	
    
}