package com.Mini_Projet_Java.Mini_Projet_Java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.NoteElement;
import com.Mini_Projet_Java.Mini_Projet_Java.Service.NoteElementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteElementController {

    @Autowired
    private NoteElementService noteElementService;

    // Récupérer toutes les notes
    @GetMapping
    public ResponseEntity<List<NoteElement>> getAllNotes() {
        List<NoteElement> notes = noteElementService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    // Récupérer une note par ID
    @GetMapping("/{id}")
    public ResponseEntity<NoteElement> getNoteById(@PathVariable Long id) {
        Optional<NoteElement> note = noteElementService.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Ajouter ou mettre à jour une note
    @PostMapping
    public ResponseEntity<NoteElement> saveOrUpdateNote(@RequestBody NoteElement noteElement) {
        NoteElement savedNote = noteElementService.saveOrUpdateNote(noteElement);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }

    // Supprimer une note par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteElementService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer les notes d'un étudiant
    @GetMapping("/by-etudiant/{etudiantId}")
    public ResponseEntity<List<NoteElement>> getNotesByEtudiant(@PathVariable Long etudiantId) {
        List<NoteElement> notes = noteElementService.getNotesByEtudiant(etudiantId);
        return ResponseEntity.ok(notes);
    }

    // Récupérer les notes d'un élément
    @GetMapping("/by-element/{elementId}")
    public ResponseEntity<List<NoteElement>> getNotesByElement(@PathVariable Long elementId) {
        List<NoteElement> notes = noteElementService.getNotesByElement(elementId);
        return ResponseEntity.ok(notes);
    }

    // Récupérer les notes par modalité
    @GetMapping("/by-modalite/{modaliteId}")
    public ResponseEntity<List<NoteElement>> getNotesByModalite(@PathVariable Long modaliteId) {
        List<NoteElement> notes = noteElementService.getNotesByModalite(modaliteId);
        return ResponseEntity.ok(notes);
    }
}
