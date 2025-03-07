package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Professeur;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.ProfesseurRepository;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    // Récupérer tous les professeurs
    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    // Récupérer un professeur par code
    public Optional<Professeur> getProfesseurByCode(Long code) {
        return professeurRepository.findById(code);
    }

    // Ajouter ou mettre à jour un professeur
    public Professeur saveOrUpdateProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }
 // Mettre à jour un professeur existant
    public Professeur updateProfesseur(Long id, Professeur professeurDetails) {
        // Vérifier si le professeur existe
        Professeur professeur = professeurRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Professeur non trouvé avec l'ID : " + id));

        // Mettre à jour les attributs
        professeur.setNom(professeurDetails.getNom());
        professeur.setPrenom(professeurDetails.getPrenom());
        professeur.setUsername(professeurDetails.getUsername());
        professeur.setPassword(professeurDetails.getPassword());
        professeur.setImage(professeurDetails.getImage());
        professeur.setSpecialite(professeurDetails.getSpecialite());

        // Sauvegarder les modifications
        return professeurRepository.save(professeur);
    }

    // Supprimer un professeur par code
    public void deleteProfesseur(long code) {
        professeurRepository.deleteById(code);
    }

    // Récupérer un professeur par nom d'utilisateur
    public Professeur getProfesseurByNomUtilisateur(String nomUtilisateur) {
        return professeurRepository.findByUsername(nomUtilisateur);
    }
}
