package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Mini_Projet_Java.Mini_Projet_Java.Model.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
	 Optional<Administrateur> findByNomUtilisateur(String username);
}