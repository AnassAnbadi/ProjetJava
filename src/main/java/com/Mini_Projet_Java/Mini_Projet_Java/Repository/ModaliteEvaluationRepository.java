package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.ModaliteEvaluation;

@Repository
public interface ModaliteEvaluationRepository extends JpaRepository<ModaliteEvaluation, Long> {
    // Méthode personnalisée si nécessaire (exemple : recherche par type de modalité)
    ModaliteEvaluation findByTypeModalite(String typeModalite);
}
