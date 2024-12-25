package com.Mini_Projet_Java.Mini_Projet_Java.Model;

import java.util.List;



import jakarta.persistence.Entity;
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
	    
	    private Semestre semestre;
	    
	    @ManyToOne
	    @JoinColumn(name="Filiere_id") 
	    
	    private Filiere filiere;

	    @OneToMany(mappedBy = "module")
	    
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
		
		

		public Module(Long codeModule, String nomModule) {
			super();
			this.id = codeModule;
			this.nomModule = nomModule;
		}
		
		

		public Module(String nomModule) {
			super();
			this.nomModule = nomModule;
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
