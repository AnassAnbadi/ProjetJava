package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Module;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.ModuleRepository;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    // Create or Update a Module
    public ResponseEntity<Module> saveModule(Module module) {
    	Optional<Module> existantModul=moduleRepository.findByNomModuleAndFiliereIdAndSemestreId(module.getNomModule(),
    			module.getFiliere().getId(),module.getSemestre().getId());
    	if(existantModul.isPresent()){
    		return ResponseEntity.status(HttpStatus.OK).body(existantModul.get());
    	}
        moduleRepository.save(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(module);
    }

    // Retrieve all Modules
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    // Retrieve a Module by ID
    public Module getModuleById(Long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }

    // Delete a Module by ID
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}

