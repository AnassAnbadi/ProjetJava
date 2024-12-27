package com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO;

public class EtudiantDTO {
    private Long id;
    private String nom;
    private String prenom;
    private Long filiereId;
    private Long semestreId;

    // Constructeur
    public EtudiantDTO(Long id, String nom, String prenom, Long filiereId, Long semestreId) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.filiereId = filiereId;
        this.semestreId = semestreId;
    }

    // Getters et setters...
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

    public Long getFiliereId() {
        return filiereId;
    }

    public void setFiliereId(Long filiereId) {
        this.filiereId = filiereId;
    }

    public Long getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Long semestreId) {
        this.semestreId = semestreId;
    }
}
