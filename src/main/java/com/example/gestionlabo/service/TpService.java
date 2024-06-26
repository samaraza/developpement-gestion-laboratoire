package com.example.gestionlabo.service;

import com.example.gestionlabo.model.*;
import com.example.gestionlabo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TpService {
    @Autowired
    private TpRepository tpRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SalleTpRepository salleTpRepository;

    @Autowired
    private PreparationRepository preparationRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Tp> findAll() {
        return tpRepository.findAll();
    }

    public Tp findById(String id) {
        return tpRepository.findById(id).orElseThrow(() -> new RuntimeException("Tp not found with id " + id));
    }

    public Tp save(Tp tp) {
        // Validate and set references
        User prof = userRepository.findById(tp.getProf().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + tp.getProf().getId()));
        SalleTp salleTp = salleTpRepository.findById(tp.getSalleTp().getId())
                .orElseThrow(() -> new RuntimeException("SalleTp not found with id " + tp.getSalleTp().getId()));

        tp.setProf(prof);
        tp.setSalleTp(salleTp);

        for (PreparationTP preparationTP : tp.getPreparations()) {
            Preparation preparation = preparationRepository.findById(preparationTP.getPreparation().getId())
                    .orElseThrow(() -> new RuntimeException("Preparation not found with id " + preparationTP.getPreparation().getId()));
            preparation.setQuantite(preparation.getQuantite() - preparationTP.getQuantite());
            preparationRepository.save(preparation);
        }

        for (ProduitTP produitTP : tp.getProduits()) {
            Produit produit = produitRepository.findById(produitTP.getProduit().getId())
                    .orElseThrow(() -> new RuntimeException("Produit not found with id " + produitTP.getProduit().getId()));
            produit.setQuantiteInitiale(produit.getQuantiteInitiale() - produitTP.getQuantite());
            produitRepository.save(produit);
        }

        return tpRepository.save(tp);
    }

    public Tp update(String id, Tp updatedTp) {
        Tp existingTp = tpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tp not found with id " + id));

        // Restore original quantities before updating
        for (PreparationTP preparationTP : existingTp.getPreparations()) {
            Preparation preparation = preparationRepository.findById(preparationTP.getPreparation().getId())
                    .orElseThrow(() -> new RuntimeException("Preparation not found with id " + preparationTP.getPreparation().getId()));
            preparation.setQuantite(preparation.getQuantite() + preparationTP.getQuantite());
            preparationRepository.save(preparation);
        }

        for (ProduitTP produitTP : existingTp.getProduits()) {
            Produit produit = produitRepository.findById(produitTP.getProduit().getId())
                    .orElseThrow(() -> new RuntimeException("Produit not found with id " + produitTP.getProduit().getId()));
            produit.setQuantiteInitiale(produit.getQuantiteInitiale() + produitTP.getQuantite());
            produitRepository.save(produit);
        }

        User prof = userRepository.findById(updatedTp.getProf().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + updatedTp.getProf().getId()));
        SalleTp salleTp = salleTpRepository.findById(updatedTp.getSalleTp().getId())
                .orElseThrow(() -> new RuntimeException("SalleTp not found with id " + updatedTp.getSalleTp().getId()));

        existingTp.setType(updatedTp.getType());
        existingTp.setJourTp(updatedTp.getJourTp());
        existingTp.setProf(prof);
        existingTp.setSalleTp(salleTp);
        existingTp.setNiveauScolaire(updatedTp.getNiveauScolaire());
        existingTp.setPreparations(updatedTp.getPreparations());
        existingTp.setProduits(updatedTp.getProduits());

        // Apply new quantities
        for (PreparationTP preparationTP : updatedTp.getPreparations()) {
            Preparation preparation = preparationRepository.findById(preparationTP.getPreparation().getId())
                    .orElseThrow(() -> new RuntimeException("Preparation not found with id " + preparationTP.getPreparation().getId()));
            preparation.setQuantite(preparation.getQuantite() - preparationTP.getQuantite());
            preparationRepository.save(preparation);
        }

        for (ProduitTP produitTP : updatedTp.getProduits()) {
            Produit produit = produitRepository.findById(produitTP.getProduit().getId())
                    .orElseThrow(() -> new RuntimeException("Produit not found with id " + produitTP.getProduit().getId()));
            produit.setQuantiteInitiale(produit.getQuantiteInitiale() - produitTP.getQuantite());
            produitRepository.save(produit);
        }

        return tpRepository.save(existingTp);
    }

    public void deleteById(String id) {
        Tp existingTp = tpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tp not found with id " + id));

        // Restore original quantities before deleting
        for (PreparationTP preparationTP : existingTp.getPreparations()) {
            Preparation preparation = preparationRepository.findById(preparationTP.getPreparation().getId())
                    .orElseThrow(() -> new RuntimeException("Preparation not found with id " + preparationTP.getPreparation().getId()));
            preparation.setQuantite(preparation.getQuantite() + preparationTP.getQuantite());
            preparationRepository.save(preparation);
        }

        for (ProduitTP produitTP : existingTp.getProduits()) {
            Produit produit = produitRepository.findById(produitTP.getProduit().getId())
                    .orElseThrow(() -> new RuntimeException("Produit not found with id " + produitTP.getProduit().getId()));
            produit.setQuantiteInitiale(produit.getQuantiteInitiale() + produitTP.getQuantite());
            produitRepository.save(produit);
        }

        tpRepository.deleteById(id);
    }
}
