package com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO;

public class ElementDTO {
    private Long id;
    private String nomElement;
    private double coefficient;
    private String moduleName;
    private String filiereName;
    private String semestreName;

    // Constructors
    public ElementDTO(Long id, String nomElement, double coefficient, String moduleName, String filiereName, String semestreName) {
        this.id = id;
        this.nomElement = nomElement;
        this.coefficient = coefficient;
        this.moduleName = moduleName;
        this.filiereName = filiereName;
        this.semestreName = semestreName;
    }
    public ElementDTO(String nomElement, double coefficient, String moduleName, String filiereName, String semestreName) {
        this.nomElement = nomElement;
        this.coefficient = coefficient;
        this.moduleName = moduleName;
        this.filiereName = filiereName;
        this.semestreName = semestreName;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomElement() {
        return nomElement;
    }

    public void setNomElement(String nomElement) {
        this.nomElement = nomElement;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getFiliereName() {
        return filiereName;
    }

    public void setFiliereName(String filiereName) {
        this.filiereName = filiereName;
    }

    public String getSemestreName() {
        return semestreName;
    }

    public void setSemestreName(String semestreName) {
        this.semestreName = semestreName;
    }
}
