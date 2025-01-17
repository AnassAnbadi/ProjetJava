package com.Mini_Projet_Java.Mini_Projet_Java.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.ModaliteEvaluation;
import com.Mini_Projet_Java.Mini_Projet_Java.Model.NoteElement;
import com.Mini_Projet_Java.Mini_Projet_Java.Service.NoteElementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteElementController {

    @Autowired
    private NoteElementService noteElementService;

    @PostMapping("/SaveAllNotes")
    public ResponseEntity<List<NoteElement>> saveAllModalites(
            @RequestBody List<NoteElement> notes) {
        List<NoteElement> savedNotes = noteElementService.saveAllNotes(notes);
        return ResponseEntity.ok(savedNotes);
        
    }

    
}
