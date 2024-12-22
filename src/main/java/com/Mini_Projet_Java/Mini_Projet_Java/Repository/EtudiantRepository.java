package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
