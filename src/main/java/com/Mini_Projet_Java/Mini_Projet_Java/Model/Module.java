package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Module {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nomModule;

	    @ManyToOne
	    @JoinColumn(name="semestre_id")
	    @JsonBackReference
	    private Semestre semestre;
	    
	    @ManyToOne
	    @JoinColumn(name="Filiere_id") 
	    @JsonBackReference
	    
	    private Filiere filiere;

	    @OneToMany(mappedBy = "module")
	    @JsonIgnore

	    private List<Element> elements;
	    
	    

	    public Module() {
			// TODO Auto-generated constructor stub
		}

		public Module(String nomModule, Semestre semestre, List<Element> elements,Filiere filiere) {
			this.nomModule = nomModule;
			this.semestre = semestre;
			this.elements = elements;
			this.filiere=filiere;
		}
	    
		public Module(Long codeModule, String nomModule, Semestre semestre, List<Element> elements,Filiere filiere) {
			this.id = codeModule;
			this.nomModule = nomModule;
			this.semestre = semestre;
			this.elements = elements;
			this.filiere=filiere;
		}
		public Module(Long codeModule, String nomModule, Semestre semestre,Filiere filiere) {
			this.id = codeModule;
			this.nomModule = nomModule;
			this.semestre = semestre;
			this.filiere=filiere;
		}
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomModule() {
			return nomModule;
		}

		public void setNomModule(String nomModule) {
			this.nomModule = nomModule;
		}

		public Semestre getSemestre() {
			return semestre;
		}

		public void setSemestre(Semestre semestre) {
			this.semestre = semestre;
		}

		public List<Element> getElements() {
			return elements;
		}

		public void setElements(List<Element> elements) {
			this.elements = elements;
		}

		public Filiere getFiliere() {
			return filiere;
		}

		public void setFiliere(Filiere filiere) {
			this.filiere = filiere;
		}
	    
	    
	    
}
