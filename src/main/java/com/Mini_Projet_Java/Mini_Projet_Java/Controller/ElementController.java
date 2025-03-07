package com.Mini_Projet_Java.Mini_Projet_Java.Controller;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Element;

import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ElementDTO;

import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ElementForProfDTO;

import com.Mini_Projet_Java.Mini_Projet_Java.Service.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elements")
public class ElementController {

    @Autowired
    private ElementService elementService;

    // Get all elements
    @GetMapping
    public List<Element> getAllElements() {
        return elementService.getAllElements();
    }
    
    //Get element by prof id
    @GetMapping("/profElemnet/{id}")

    public ResponseEntity<List<ElementForProfDTO>> getElementsByProf(@PathVariable Long id) {
        List<ElementForProfDTO> elements = elementService.getElementsByProf(id);
        if (elements.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if no elements are found
        }
        return ResponseEntity.ok(elements); // Return 200 with the list of elements
    }


    // Get element by ID
    @GetMapping("/{id}")
    public ResponseEntity<Element> getElementById(@PathVariable Long id) {
        Optional<Element> element = elementService.getElementById(id);
        return element.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new element
    @PostMapping("/add")
    public ResponseEntity<Element> createElement(@RequestBody Element element) {
        Element createdElement = elementService.createElement(element);
        return new ResponseEntity<>(createdElement, HttpStatus.CREATED);
    }

    // Update an existing element
    @PutMapping("/{id}")
    public ResponseEntity<Element> updateElement(@PathVariable Long id, @RequestBody Element element) {
        Element updatedElement = elementService.updateElement(id, element);
        return updatedElement != null ? ResponseEntity.ok(updatedElement) : ResponseEntity.notFound().build();
    }

    // Delete an element
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElement(@PathVariable Long id) {
        return elementService.deleteElement(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
