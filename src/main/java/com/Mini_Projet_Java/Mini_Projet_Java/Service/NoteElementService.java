package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.ModaliteEvaluation;
import com.Mini_Projet_Java.Mini_Projet_Java.Model.NoteElement;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.EtudiantForProfDTO;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.EtudiantRepository;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.NoteElementRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteElementService {

    @Autowired
    private NoteElementRepository noteElementRepository;
    


    public List<NoteElement> saveAllNotes(List<NoteElement> notes) {
        if (notes == null || notes.isEmpty()) {
            return Collections.emptyList();
        }

        long modaliteId = notes.get(0).getModalite().getId();
        List<NoteElement> allExistingNotes = noteElementRepository.findAll();
        
        // Filter existing notes for the specific modaliteId
        List<NoteElement> existingNotes = allExistingNotes.stream()
            .filter(note -> note.getModalite().getId().equals(modaliteId))
            .collect(Collectors.toList());

        System.out.println(notes);

        // Si aucune note n'existe, on sauvegarde toutes les nouvelles notes
        if (existingNotes.isEmpty()) {
            return noteElementRepository.saveAll(notes);
        }

        List<NoteElement> resultNotes = new ArrayList<>();

        // Pour chaque nouvelle note
        for (NoteElement newNote : notes) {
            boolean noteExists = false;

            // On cherche si une note existe déjà pour cet élément
            for (NoteElement existingNote : existingNotes) {
                // Ajoutez ici les critères de correspondance appropriés
                // Par exemple, si les notes sont liées à un étudiant :
                if (existingNote.getEtudiant().getId().equals(newNote.getEtudiant().getId())) {
                    // Mise à jour des propriétés de la note existante
                    existingNote.setNoteElement(newNote.getNoteElement());
                    existingNote.setAbsent(newNote.getAbsent());
                    // Ajoutez ici d'autres propriétés à mettre à jour si nécessaire

                    resultNotes.add(noteElementRepository.save(existingNote));
                    noteExists = true;
                    break;
                }
            }

            // Si la note n'existe pas, on l'ajoute
            if (!noteExists) {
                resultNotes.add(noteElementRepository.save(newNote));
            }
        }

        return resultNotes;
    }

}
