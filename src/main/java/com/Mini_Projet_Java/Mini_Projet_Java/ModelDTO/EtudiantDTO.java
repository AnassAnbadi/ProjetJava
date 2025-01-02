package com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO;

public class EtudiantDTO {
	   private Long id;
	    private String nomEtudiant;
	    private String prenomEtudiant;
	    private String nomFiliere;
	    private String nomSemestre;
		public EtudiantDTO(Long id, String nomEtudiant, String prenomEtudiant, String nomFiliere, String nomSemestre) {
			super();
			this.id = id;
			this.nomEtudiant = nomEtudiant;
			this.prenomEtudiant = prenomEtudiant;
			this.nomFiliere = nomFiliere;
			this.nomSemestre = nomSemestre;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getNomFiliere() {
			return nomFiliere;
		}
		public void setNomFiliere(String nomFiliere) {
			this.nomFiliere = nomFiliere;
		}
		public String getNomSemestre() {
			return nomSemestre;
		}
		public void setNomSemestre(String nomSemestre) {
			this.nomSemestre = nomSemestre;
		}
}
