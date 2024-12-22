package com.Mini_Projet_Java.Mini_Projet_Java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.NoteElement;

import java.util.List;

@Repository
public interface NoteElementRepository extends JpaRepository<NoteElement, Long> {
    // Rechercher toutes les notes d'un étudiant
    List<NoteElement> findByEtudiantId(Long etudiantId);

    // Rechercher toutes les notes d'un élément
    List<NoteElement> findByElementId(Long elementId);

    // Rechercher toutes les notes associées à une modalité spécifique
    List<NoteElement> findByModaliteId(Long modaliteId);
}
