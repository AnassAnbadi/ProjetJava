package com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO;

public class StudentDTO {
    private Long id;
    private String name;
    private String lastName;
    private Double grade;
    private int absent;
    
   
    
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(Long id, String name, String lastName, Double grade, int absent) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.grade = grade;
        this.absent = absent;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public int getAbsent() {
		return absent;
	}

	public void setAbsent(int absent) {
		this.absent = absent;
	}
    
    
}

