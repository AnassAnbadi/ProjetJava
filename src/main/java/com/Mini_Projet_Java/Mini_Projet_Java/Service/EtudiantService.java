package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.Etudiant;
import com.Mini_Projet_Java.Mini_Projet_Java.Model.Filiere;
import com.Mini_Projet_Java.Mini_Projet_Java.Model.Semestre;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.EtudiantDTO;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtudiantService {

	   @Autowired
	    private EtudiantRepository etudiantRepository;

	    @Autowired
	    private FiliereService filiereService;

	    @Autowired
	    private SemestreService semestreService;

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
    

    // Méthode de conversion des étudiants en DTOs
    public List<EtudiantDTO> getAllEtudiantsDto() {
        List<Etudiant> etudiants = getAllEtudiants();
        return etudiants.stream()
                .map(etudiant -> new EtudiantDTO(
                        etudiant.getId(),
                        etudiant.getNomEtudiant(),
                        etudiant.getPrenomEtudiant(),
                        etudiant.getFiliere().getNomFiliere(),  // Assuming Filiere has a getNomFiliere() method
                        etudiant.getSemestre().getNom()  // Assuming Semestre has a getNomSemestre() method
                ))
                .collect(Collectors.toList());
    }

    public Etudiant getEtudiantByCode(Long code) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(code);
        
        return etudiant.orElse(null);
    }


    public Etudiant addEtudiant(EtudiantDTO etudiantDTO) {
        Filiere filiere = filiereService.getFiliereBynom(etudiantDTO.getNomFiliere());
        Semestre semestre = semestreService.getSemestreByNom(etudiantDTO.getNomSemestre());

        if (filiere == null || semestre == null) {
            throw new RuntimeException("Filiere ou Semestre introuvable !");
        }

        // Conversion de EtudiantDTO en Etudiant
        Etudiant etudiant = new Etudiant(
                etudiantDTO.getNomEtudiant(),
                etudiantDTO.getPrenomEtudiant(),
                filiere,
                semestre
        );

        // Sauvegarde de l'étudiant dans la base de données
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Long code, Etudiant updatedEtudiant) {
        if (etudiantRepository.existsById(code)) {
            updatedEtudiant.setId(code);
            return etudiantRepository.save(updatedEtudiant);
        }
        return null;
    }

    public boolean deleteEtudiant(Long code) {
        if (etudiantRepository.existsById(code)) {
            etudiantRepository.deleteById(code);
            return true;
        }
        return false;
    }
    
    //list etudiant by prof et element
   // public List<Etudiant> getEtudiantsByProfesseur_Element(Long professeurId,Long ElementId) {
       // return etudiantRepository.findEtudiantsByProfesseurIdElementId(professeurId,ElementId);
    //}
	/*
	 * public List<EtudiantDTO> findEtudiantsByProfesseurIdElementId(Long
	 * professeurId, Long elementId) { List<Etudiant> etudiants =
	 * etudiantRepository.findEtudiantsByProfesseurIdElementId(professeurId,
	 * elementId); return etudiants.stream() .map(e -> new EtudiantDTO(e.getId(),
	 * e.getNomEtudiant(),
	 * e.getPrenomEtudiant(),e.getFiliere().getId(),e.getSemestre().getId()))
	 * .collect(Collectors.toList()); }
	 */
}
