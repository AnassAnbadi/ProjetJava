package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class Etudiant {
	@Id
    @Column(name = "code", unique = true, nullable = false)
    private String codeEtudiant;
	@Column(name = "nom")
    private String nomEtudiant;
	@Column(name = "prenom")
    private String prenomEtudiant;
    
    @ManyToOne
    @JoinColumn(name="filiere_id")
    private Filiere filiere;

    @ManyToOne
    @JoinColumn(name="semestre_id")
    private Semestre semestre;

    @OneToMany(mappedBy = "etudiant")
    private List<NoteElement> notes;
    
    private static int nextId = 1; 

	public Etudiant( String nomEtudiant, String prenomEtudiant, Filiere filiere, Semestre semestre,
			List<NoteElement> notes) {
		this.codeEtudiant = generateCode();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.filiere = filiere;
		this.semestre = semestre;
		this.notes = notes;
	}


	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getCodeEtudiant() {
		return codeEtudiant;
	}


	public void setCodeEtudiant(String codeEtudiant) {
		this.codeEtudiant = codeEtudiant;
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


	public static String generateCode() {
        synchronized (Etudiant.class) { // Synchronisation pour les environnements multithreadés
            String code = "code" + nextId;
            nextId++; 
            return code;
        }
    }
}
