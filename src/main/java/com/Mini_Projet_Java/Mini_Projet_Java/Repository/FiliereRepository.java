package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Filiere;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
	
	Optional<Filiere> findByNomFiliere(String nomFiliere);
}
