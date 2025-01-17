package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class NoteElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double noteElement;
    private int Absent;
    
    @ManyToOne()
    @JoinColumn(name="element_id")
    private Element element;



    @ManyToOne()
    @JoinColumn(name="modalite_id")
  
    private ModaliteEvaluation modalite;
    
    @ManyToOne()
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;


	public NoteElement() {
		// TODO Auto-generated constructor stub
	}


	public NoteElement(Long id, double noteElement, int absent, Element element,
			ModaliteEvaluation modalite, Etudiant etudiant) {
		super();
		this.id = id;
		this.noteElement = noteElement;
		Absent = absent;
		this.element = element;
		this.modalite = modalite;
		this.etudiant = etudiant;
	}


	public NoteElement( double noteElement, int absent, Element element, ModaliteEvaluation modalite,
			Etudiant etudiant) {
		super();
		this.noteElement = noteElement;
		Absent = absent;
		this.element = element;
		this.modalite = modalite;
		this.etudiant = etudiant;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getNoteElement() {
		return noteElement;
	}


	public void setNoteElement(double noteElement) {
		this.noteElement = noteElement;
	}


	public int getAbsent() {
		return Absent;
	}


	public void setAbsent(int absent) {
		Absent = absent;
	}


	public Element getElement() {
		return element;
	}


	public void setElement(Element element) {
		this.element = element;
	}


	public ModaliteEvaluation getModalite() {
		return modalite;
	}


	public void setModalite(ModaliteEvaluation modalite) {
		this.modalite = modalite;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	
}
