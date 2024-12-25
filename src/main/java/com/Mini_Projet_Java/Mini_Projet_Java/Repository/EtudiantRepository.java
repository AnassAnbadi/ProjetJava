package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	@Query("SELECT DISTINCT e FROM Etudiant e " +
		       "JOIN e.filiere f " +
		       "JOIN f.module m " +
		       "JOIN m.elements el "+
		       "WHERE el.id= :elementId and el.professeur.id = :professeurId  ")
		List<Etudiant> findEtudiantsByProfesseurIdElementId(@Param("professeurId") Long professeurId,@Param("elementId") Long elementId);

}
