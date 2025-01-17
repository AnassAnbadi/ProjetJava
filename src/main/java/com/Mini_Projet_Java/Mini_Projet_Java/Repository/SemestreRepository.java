package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

	 Optional<Semestre> findByNom(String nom);
    // Vous pouvez ajouter des méthodes de recherche personnalisées ici si nécessaire
}
