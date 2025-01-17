package com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO;

public class ModaliteElementDTO {
    private Long id;
    private double coefficient;
    private String typeModalite;
    private String nomElement;
    private String nomModule;
    private String nomFiliere;
    private String nomSemestre;
    private boolean isValidate;
    
    
	public ModaliteElementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ModaliteElementDTO(Long id, double coefficient, String typeModalite,boolean isValidate, String nomElement, String nomModule,
			String nomFiliere, String nomSemestre) {
		super();
		this.id = id;
		this.coefficient = coefficient;
		this.typeModalite = typeModalite;
		this.nomElement = nomElement;
		this.nomModule = nomModule;
		this.nomFiliere = nomFiliere;
		this.nomSemestre = nomSemestre;
		this.isValidate = isValidate;
	}


	public ModaliteElementDTO(double coefficient, String typeModalite,boolean isValidate, String nomElement, String nomModule,
			String nomFiliere, String nomSemestre) {
		super();
		this.coefficient = coefficient;
		this.typeModalite = typeModalite;
		this.nomElement = nomElement;
		this.nomModule = nomModule;
		this.nomFiliere = nomFiliere;
		this.nomSemestre = nomSemestre;
		this.isValidate = isValidate;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getCoefficient() {
		return coefficient;
	}


	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}


	public String getTypeModalite() {
		return typeModalite;
	}


	public void setTypeModalite(String typeModalite) {
		this.typeModalite = typeModalite;
	}


	public String getNomElement() {
		return nomElement;
	}


	public void setNomElement(String nomElement) {
		this.nomElement = nomElement;
	}


	public String getNomModule() {
		return nomModule;
	}


	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
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


	public boolean isValidate() {
		return isValidate;
	}


	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}

    // Constructeur
	
	
   
}