package com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO;

public class FiliereDTO  {
    private Long id;
    private String nomFiliere;

    // Constructeurs
    public FiliereDTO() {
    }

    public FiliereDTO(Long id, String nomFiliere) {
        this.id = id;
        this.nomFiliere = nomFiliere;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
    }
}
