package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Administarateur")
public class Administarateur {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nom;

	   
	    private String prenom;

	    private String nomUtilisateur;

	    private String motDePasse;

	    private String image;

	   

	    public Administarateur(Long id,String nom, String prenom, String nomUtilisateur, String motDePasse, String image) {
	        this.id = id;
	        this.nom = nom;
	        this.prenom = prenom;
	        this.nomUtilisateur = nomUtilisateur;
	        this.motDePasse = motDePasse;
	        this.image = image;
	    }

	    
	    

	    public Administarateur() {
			// TODO Auto-generated constructor stub
		}




		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
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


}
