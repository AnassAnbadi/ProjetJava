package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class ModaliteEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeModalite;
    private double coefficient;

    @OneToMany(mappedBy = "modalite")
    private List<NoteElement> notes;

	public ModaliteEvaluation() {
		// TODO Auto-generated constructor stub
	}

	public ModaliteEvaluation(Long id, String typeModalite, double coefficient, List<NoteElement> notes) {
		this.id = id;
		this.typeModalite = typeModalite;
		this.coefficient = coefficient;
		this.notes = notes;
	}
	
	public ModaliteEvaluation(String typeModalite, double coefficient, List<NoteElement> notes) {
		this.typeModalite = typeModalite;
		this.coefficient = coefficient;
		this.notes = notes;
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

	public List<NoteElement> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteElement> notes) {
		this.notes = notes;
	}
	
	
	
	

    
}