package com.Mini_Projet_Java.Mini_Projet_Java.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Mini_Projet_Java.Mini_Projet_Java.Model.ModaliteEvaluation;
import com.Mini_Projet_Java.Mini_Projet_Java.ModelDTO.ModaliteElementDTO;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.ElementRepository;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.ModaliteEvaluationRepository;
import com.Mini_Projet_Java.Mini_Projet_Java.Repository.NoteElementRepository;

@Service
public class ModaliteEvaluationService {

    @Autowired
    private ModaliteEvaluationRepository modaliteEvaluationRepository;
    
    @Autowired
    private ElementRepository elementRepo;
    @Autowired
    private NoteElementRepository Noterepo;

    // Récupérer toutes les modalités d'évaluation
    public List<ModaliteEvaluation> getAllModalites() {
        return modaliteEvaluationRepository.findAll();
    }

    // Récupérer une modalité d'évaluation par ID
    public Optional<ModaliteEvaluation> getModaliteById(Long id) {
        return modaliteEvaluationRepository.findById(id);
    }


    // Ajouter une liste de modalités d'évaluation
    public List<ModaliteEvaluation> saveAllModalites(List<ModaliteEvaluation> modalites) {
        return modaliteEvaluationRepository.saveAll(modalites);
    }
    
    
    @Transactional
    public List<ModaliteEvaluation> updateAllModalites(List<ModaliteEvaluation> modalites) {
        List<ModaliteEvaluation> updatedModalites = new ArrayList<>();
        Set<Long> receivedIds = new HashSet<>();

        List<ModaliteEvaluation> allModalites = modaliteEvaluationRepository.findByElementId(modalites.get(0).getElement().getId());
        for (ModaliteEvaluation modalite : modalites) {
            if (modalite.getId() != null) {
                receivedIds.add(modalite.getId());
                ModaliteEvaluation existingModalite = modaliteEvaluationRepository.findById(modalite.getId())
                    .orElse(new ModaliteEvaluation());

                // Update properties
                existingModalite.setCoefficient(modalite.getCoefficient());
                existingModalite.setTypeModalite(modalite.getTypeModalite());
                existingModalite.setElement(modalite.getElement());
                // Update other fields as necessary

                updatedModalites.add(modaliteEvaluationRepository.save(existingModalite));
            } else {
                // This is a new modalite
                updatedModalites.add(modaliteEvaluationRepository.save(modalite));
            }
        }

        //Delete modalites that were not in the received list
        for (ModaliteEvaluation modalite : allModalites) {
            if (!receivedIds.contains(modalite.getId())) {
                modaliteEvaluationRepository.delete(modalite);
            }
       }

        return updatedModalites;
    }

    // Ajouter ou mettre à jour une modalité d'évaluation
    public ModaliteEvaluation saveOrUpdateModalite(ModaliteEvaluation modalite) {
        return modaliteEvaluationRepository.save(modalite);
    }

    // Supprimer une modalité d'évaluation par ID
    public void deleteModalite(Long id) {
        modaliteEvaluationRepository.deleteById(id);
    }

    // Récupérer une modalité d'évaluation par type
    public ModaliteEvaluation getModaliteByType(String typeModalite) {
        return modaliteEvaluationRepository.findByTypeModalite(typeModalite);
    }
 // find by element id
    public List<ModaliteElementDTO> getModalitesByElementId(Long elementId) {
        return modaliteEvaluationRepository.findModaliteAndElementByElementId(elementId);
    }
}
