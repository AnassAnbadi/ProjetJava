package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Element {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomElement;
    private double coefficient;

    @ManyToOne
    @JoinColumn(name="module_id" )
    private Module module;
    
    @ManyToOne
    @JoinColumn(name="professeur_id")
    private Professeur professeur;

    @OneToMany(mappedBy = "element")
    private List<NoteElement> notes;

	public Element() {
		// TODO Auto-generated constructor stub
	}

	public Element(Long idElement, String nomElement, double coefficient, Module module, Professeur professeur,
			List<NoteElement> notes) {
		this.id = idElement;
		this.nomElement = nomElement;
		this.coefficient = coefficient;
		this.module = module;
		this.professeur = professeur;
		this.notes = notes;
	}

	public Element(String nomElement, double coefficient, Module module, Professeur professeur,
			List<NoteElement> notes) {
		this.nomElement = nomElement;
		this.coefficient = coefficient;
		this.module = module;
		this.professeur = professeur;
		this.notes = notes;
	}
	public Element(String nomElement, double coefficient, Module module, Professeur professeur) {
		this.nomElement = nomElement;
		this.coefficient = coefficient;
		this.module = module;
		this.professeur = professeur;
	}
	


	public Element(String nomElement, double coefficient) {
		super();
		this.nomElement = nomElement;
		this.coefficient = coefficient;
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
	
	
    
    
    
    
    

}
