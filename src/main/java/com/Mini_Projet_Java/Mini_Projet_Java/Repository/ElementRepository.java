package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Element;

import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ElementForProfDTO;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {

	@Query("SELECT new com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ElementForProfDTO(e.id, e.nomElement, e.coefficient, " +
		       "m.nomModule, f.nomFiliere, s.nom) " +
		       "FROM Element e " + 
		       "JOIN e.module m " + 
		       "JOIN m.filiere f " +
		       "JOIN m.semestre s " +
		       "WHERE e.professeur.id= :profId")
		List<ElementForProfDTO> findElementsByProfesseurId(@Param("profId") Long profId);
}
