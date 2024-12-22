package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import jakarta.persistence.*;

@Entity
public class NoteElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="element_id")
    private Element element;

    @ManyToOne
    @JoinColumn(name="etudiant_id")
    private Etudiant etudiant;

    private double noteElement;

    @ManyToOne
    @JoinColumn(name="modalite_id")
    private ModaliteEvaluation modalite;
    
    

	public NoteElement() {
		// TODO Auto-generated constructor stub
	}



	public NoteElement(Long id, Element element, Etudiant etudiant, double noteElement, ModaliteEvaluation modalite) {
		this.id = id;
		this.element = element;
		this.etudiant = etudiant;
		this.noteElement = noteElement;
		this.modalite = modalite;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Element getElement() {
		return element;
	}



	public void setElement(Element element) {
		this.element = element;
	}



	public Etudiant getEtudiant() {
		return etudiant;
	}



	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}



	public double getNoteElement() {
		return noteElement;
	}



	public void setNoteElement(double noteElement) {
		this.noteElement = noteElement;
	}



	public ModaliteEvaluation getModalite() {
		return modalite;
	}



	public void setModalite(ModaliteEvaluation modalite) {
		this.modalite = modalite;
	}
	
	
    
}
