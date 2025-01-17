package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table

public class Element {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomElement;
    private double coefficient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="module_id" )
    
    private Module module;
    
    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name="professeur_id")
    
    private Professeur professeur;

    @OneToMany(mappedBy = "element")
    @JsonIgnore
    private List<NoteElement> notes;


	public Element() {
		// TODO Auto-generated constructor stub
	}


	public Element(Long id, String nomElement, double coefficient, Module module, Professeur professeur,
			List<NoteElement> notes, List<ModaliteEvaluation> modalite) {
		super();
		this.id = id;
		this.nomElement = nomElement;
		this.coefficient = coefficient;
		this.module = module;
		this.professeur = professeur;
		this.notes = notes;
		modalite = modalite;
	}
	public Element(Long idElement, String nomElement, double coefficient, Module module, Professeur professeur) {
		this.id = idElement;
		this.nomElement = nomElement;
		this.coefficient = coefficient;
		this.module = module;
		this.professeur = professeur;
	}


	public Element(String nomElement, double coefficient, Module module, Professeur professeur, List<NoteElement> notes,
			List<ModaliteEvaluation> modalite) {
		super();
		this.nomElement = nomElement;
		this.coefficient = coefficient;
		this.module = module;
		this.professeur = professeur;
		this.notes = notes;
		modalite = modalite;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomElement() {
		return nomElement;
	}


	public void setNomElement(String nomElement) {
		this.nomElement = nomElement;
	}


	public double getCoefficient() {
		return coefficient;
	}


	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}


	public Module getModule() {
		return module;
	}


	public void setModule(Module module) {
		this.module = module;
	}


	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}


	public List<NoteElement> getNotes() {
		return notes;
	}


	public void setNotes(List<NoteElement> notes) {
		this.notes = notes;
	}


	public List<ModaliteEvaluation> getModalite() {
		return getModalite();
	}


	public void setModalite(List<ModaliteEvaluation> modalite) {
		modalite = modalite;
	}

	
    

}
