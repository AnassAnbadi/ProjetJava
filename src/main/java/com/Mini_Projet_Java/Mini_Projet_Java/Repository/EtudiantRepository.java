package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.StudentDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	@Query("SELECT DISTINCT NEW com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.StudentDTO(" +
		    "e.id, e.nomEtudiant, e.prenomEtudiant, " +
		    "COALESCE(n.noteElement, 0), " +
		    "COALESCE(n.Absent, false)) " +
		    "FROM Element el " +
		    "JOIN el.module m " +
		    "JOIN m.filiere f " +
		    "JOIN f.etudiants e " +
		    "LEFT JOIN el.notes n " +
		    "ON n.etudiant.id = e.id AND n.modalite.id = :modaliteId " +
		    "WHERE el.id = :elementId ")
		List<StudentDTO> findStudentsWithGradesByElementId(
		    @Param("elementId") Long elementId,
		    @Param("modaliteId") Long modaliteId);
}


