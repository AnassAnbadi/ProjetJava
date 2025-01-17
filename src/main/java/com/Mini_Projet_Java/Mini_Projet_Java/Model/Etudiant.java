package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table
public class Etudiant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generation ID
    private Long id;
    private String nomEtudiant;
    private String prenomEtudiant;

    @ManyToOne
    @JoinColumn(name = "filiere_id")
    @JsonBackReference
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name = "semestre_id")
    @JsonBackReference
    private Semestre semestre;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<NoteElement> notes;

    public Etudiant() {
    }

    public Etudiant(String nomEtudiant, String prenomEtudiant, Filiere filiere, Semestre semestre, List<NoteElement> notes) {
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.filiere = filiere;
        this.semestre = semestre;
        this.notes = notes;
    }
    public Etudiant(Long codeEtudiant,String nomEtudiant, String prenomEtudiant, Filiere filiere, Semestre semestre) {
    	this.id = codeEtudiant;
    	this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.filiere = filiere;
        this.semestre = semestre;
    }
    
    public Etudiant(String nomEtudiant, String prenomEtudiant, Filiere filiere, Semestre semestre) {
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.filiere = filiere;
        this.semestre = semestre;
        
    } 

    public Etudiant(Long codeEtudiant, String nomEtudiant, String prenomEtudiant) {
		super();
		this.id = codeEtudiant;
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
	}

	public Etudiant(String nomEtudiant, String prenomEtudiant) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long codeEtudiant) {
        this.id = codeEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<NoteElement> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteElement> notes) {
        this.notes = notes;
    }
}
