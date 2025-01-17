package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.ModaliteEvaluation;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ModaliteElementDTO;

@Repository
public interface ModaliteEvaluationRepository extends JpaRepository<ModaliteEvaluation, Long> {
    // Méthode personnalisée si nécessaire (exemple : recherche par type de modalité)
    ModaliteEvaluation findByTypeModalite(String typeModalite);
    List<ModaliteEvaluation> findByElementId(Long id);
    
    @Query("SELECT new com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ModaliteElementDTO(" +
    	       "m.id, m.coefficient, m.typeModalite,m.isvalidate, e.nomElement, mod.nomModule, f.nomFiliere, s.nom ) " +
    	       "FROM ModaliteEvaluation m " +
    	       "JOIN m.element e " +
    	       "JOIN e.module mod " +
    	       "JOIN mod.filiere f " +
    	       "JOIN mod.semestre s " +
    	       "WHERE e.id = :elementId")
    	List<ModaliteElementDTO> findModaliteAndElementByElementId(@Param("elementId") Long elementId);

}
