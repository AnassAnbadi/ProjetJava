package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Professeur")
public class Professeur {

    @Id
    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "image")
    private String image;
    
    @Column(name = "specialite")
    private String specialite;
    
    @OneToMany(mappedBy = "professeur")
    private List<Element> elements;


	// Variable statique pour stocker l'index suivant
    private static int nextId = 1; 

    public Professeur(String nom, String prenom, String nomUtilisateur, String motDePasse, String image,String specialite) {
        this.code = generateCode(); 
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.image = image;
        this.specialite=specialite;
    }

    
    

    public Professeur() {
		// TODO Auto-generated constructor stub
	}




	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNomUtilisateur() {
		return nomUtilisateur;
	}



	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}



	public String getMotDePasse() {
		return motDePasse;
	}



	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}


	public String getSepicialite() {
		return specialite;
	}




	public void setSepicialite(String specialite) {
		this.specialite = specialite;
	}


	public static String generateCode() {
        synchronized (Professeur.class) { // Synchronisation pour les environnements multithreadés
            String code = "code" + nextId;
            nextId++; 
            return code;
        }
    }
	
	
}