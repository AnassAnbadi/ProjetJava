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


    private double noteElement;

    @ManyToOne
    @JoinColumn(name="modalite_id")
    private ModaliteEvaluation modalite;
    
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    

	public NoteElement() {
		// TODO Auto-generated constructor stub
	}




	public NoteElement(Element element, double noteElement, ModaliteEvaluation modalite, Etudiant etudiant) {
		super();
		this.element = element;
		this.noteElement = noteElement;
		this.modalite = modalite;
		this.etudiant = etudiant;
	}







	public NoteElement(Long id, Element element, double noteElement, ModaliteEvaluation modalite, Etudiant etudiant) {
		super();
		this.id = id;
		this.element = element;
		this.noteElement = noteElement;
		this.modalite = modalite;
		this.etudiant = etudiant;
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




	public Etudiant getEtudiant() {
		return etudiant;
	}




	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	
    
}
