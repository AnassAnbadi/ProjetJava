package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table
public class ModaliteEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeModalite;
    private double coefficient;
    private boolean isvalidate;

    @OneToMany(mappedBy = "modalite")
    
    private List<NoteElement> notes;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="element_id")
    private Element element;


    
	public ModaliteEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ModaliteEvaluation(Long id, String typeModalite, double coefficient, boolean isvalidate,
			List<NoteElement> notes, Element element) {
		super();
		this.id = id;
		this.typeModalite = typeModalite;
		this.coefficient = coefficient;
		this.isvalidate = isvalidate;
		this.notes = notes;
		this.element = element;
	}



	public ModaliteEvaluation(String typeModalite, double coefficient, boolean isvalidate, List<NoteElement> notes,
			Element element) {
		super();
		this.typeModalite = typeModalite;
		this.coefficient = coefficient;
		this.isvalidate = isvalidate;
		this.notes = notes;
		this.element = element;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTypeModalite() {
		return typeModalite;
	}



	public void setTypeModalite(String typeModalite) {
		this.typeModalite = typeModalite;
	}



	public double getCoefficient() {
		return coefficient;
	}



	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}



	public boolean isIsvalidate() {
		return isvalidate;
	}



	public void setIsvalidate(boolean isvalidate) {
		this.isvalidate = isvalidate;
	}



	public List<NoteElement> getNotes() {
		return notes;
	}



	public void setNotes(List<NoteElement> notes) {
		this.notes = notes;
	}



	public Element getElement() {
		return element;
	}



	public void setElement(Element element) {
		this.element = element;
	}

	
	

    
}




