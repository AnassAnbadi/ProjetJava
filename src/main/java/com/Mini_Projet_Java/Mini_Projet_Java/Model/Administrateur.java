package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Administrateur")
public class Administrateur {




		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nomUtilisateur;

	    private String motDePasse;

	    private String image;

	    
	    public Administrateur(String nomUtilisateur, String motDePasse, String image) {
			super();
			this.nomUtilisateur = nomUtilisateur;
			this.motDePasse = motDePasse;
			this.image = image;
		}
	   
        
	    
	    public Administrateur(String nomUtilisateur, String motDePasse) {
			this.nomUtilisateur = nomUtilisateur;
			this.motDePasse = motDePasse;
		}



		public Administrateur(Long id, String nomUtilisateur, String motDePasse, String image) {
	        this.id = id;
	        this.nomUtilisateur = nomUtilisateur;
	        this.motDePasse = motDePasse;
	        this.image = image;
	    }

	    
	    

	    public Administrateur() {
			// TODO Auto-generated constructor stub
		}




		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
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