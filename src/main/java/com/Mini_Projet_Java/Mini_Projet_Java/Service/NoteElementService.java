package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.NoteElement;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.NoteElementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NoteElementService {

    @Autowired
    private NoteElementRepository noteElementRepository;

    // Récupérer toutes les notes
    public List<NoteElement> getAllNotes() {
        return noteElementRepository.findAll();
    }

    // Récupérer une note par ID
    public Optional<NoteElement> getNoteById(Long id) {
        return noteElementRepository.findById(id);
    }

    // Ajouter ou mettre à jour une note
    public NoteElement saveOrUpdateNote(NoteElement noteElement) {
        return noteElementRepository.save(noteElement);
    }

    // Supprimer une note par ID
    public void deleteNote(Long id) {
        noteElementRepository.deleteById(id);
    }

    // Récupérer toutes les notes d'un étudiant
    public List<NoteElement> getNotesByEtudiant(Long etudiantId) {
        return noteElementRepository.findByEtudiantId(etudiantId);
    }

    // Récupérer toutes les notes d'un élément
    public List<NoteElement> getNotesByElement(Long elementId) {
        return noteElementRepository.findByElementId(elementId);
    }

    // Récupérer toutes les notes par modalité
    public List<NoteElement> getNotesByModalite(Long modaliteId) {
        return noteElementRepository.findByModaliteId(modaliteId);
    }
}
