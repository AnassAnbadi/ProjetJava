package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Element;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementService {

    @Autowired
    private ElementRepository elementRepository;

    // Get all elements
    public List<Element> getAllElements() {
        return elementRepository.findAll();
    }

    // Get element by ID
    public Optional<Element> getElementById(Long id) {
        return elementRepository.findById(id);
    }

    // Create a new element
    public Element createElement(Element element) {
    	
        return elementRepository.save(element);
    }

    // Update an existing element
    public Element updateElement(Long id, Element element) {
        if (elementRepository.existsById(id)) {
            element.setId(id);
            return elementRepository.save(element);
        }
        return null; // or throw exception
    }

    // Delete an element
    public boolean deleteElement(Long id) {
        if (elementRepository.existsById(id)) {
            elementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
