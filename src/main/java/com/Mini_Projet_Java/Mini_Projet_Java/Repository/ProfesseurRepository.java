package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Professeur;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, String> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire, comme findByNomUtilisateur
    Professeur findByNomUtilisateur(String nomUtilisateur);
}
