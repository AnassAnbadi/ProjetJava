package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Semestre;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.SemestreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    @Autowired
    private SemestreRepository semestreRepository;

    // Récupérer tous les semestres
    public List<Semestre> getAllSemestres() {
        return semestreRepository.findAll();
    }
    public Semestre findByNom(String nom) {
        return semestreRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Semestre introuvable avec le nom : " + nom));
    }
    
    // Récupérer un semestre par ID
    public Optional<Semestre> getSemestreById(Long id) {
        return semestreRepository.findById(id);
    }

    // Ajouter ou mettre à jour un semestre
    public Semestre saveOrUpdateSemestre(Semestre semestre) {
        return semestreRepository.save(semestre);
    }

    // Supprimer un semestre par ID
    public void deleteSemestre(Long id) {
        semestreRepository.deleteById(id);
    }

	public Semestre updateSemestre(Long id, Semestre semestre) {
		if(semestreRepository.existsById(id)) {
            semestre.setId(id);
            return semestreRepository.save(semestre);
        }
        return null; // or throw exception
	}
}
