package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Preparation;
import com.example.gestionlabo.model.Produit;
import com.example.gestionlabo.repository.PreparationRepository;
import com.example.gestionlabo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreparationService {
    @Autowired
    private PreparationRepository preparationRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Preparation> findAll() {
        return preparationRepository.findAll();
    }

    public Preparation findById(String id) {
        return preparationRepository.findById(id).orElseThrow(() -> new RuntimeException("Preparation not found with id " + id));
    }

    public Preparation save(Preparation preparation) {
        // Verify produits exist and adjust quantities
        Produit produit1 = produitRepository.findById(preparation.getProduit1().getId()).orElseThrow(() -> new RuntimeException("Produit1 not found with id " + preparation.getProduit1().getId()));
        Produit produit2 = produitRepository.findById(preparation.getProduit2().getId()).orElseThrow(() -> new RuntimeException("Produit2 not found with id " + preparation.getProduit2().getId()));

        // Ensure the quantities are sufficient before saving
        if (produit1.getQuantiteInitiale() < preparation.getQuantite1() || produit2.getQuantiteInitiale() < preparation.getQuantite2()) {
            throw new RuntimeException("Insufficient quantity for the produits");
        }
        // Adjust the quantities
        produit1.setQuantiteInitiale(produit1.getQuantiteInitiale() - preparation.getQuantite1());
        produit2.setQuantiteInitiale(produit2.getQuantiteInitiale() - preparation.getQuantite2());

        produitRepository.save(produit1);
        produitRepository.save(produit2);

        return preparationRepository.save(preparation);
    }

    public Preparation update(String id, Preparation updatedPreparation) {
        Preparation existingPreparation = preparationRepository.findById(id).orElseThrow(() -> new RuntimeException("Preparation not found with id " + id));

        // Restore original quantities
        Produit produit1 = existingPreparation.getProduit1();
        Produit produit2 = existingPreparation.getProduit2();
        produit1.setQuantiteInitiale(produit1.getQuantiteInitiale() + existingPreparation.getQuantite1());
        produit2.setQuantiteInitiale(produit2.getQuantiteInitiale() + existingPreparation.getQuantite2());

        produitRepository.save(produit1);
        produitRepository.save(produit2);

        // Set new values and adjust quantities
        produit1 = produitRepository.findById(updatedPreparation.getProduit1().getId()).orElseThrow(() -> new RuntimeException("Produit1 not found with id " + updatedPreparation.getProduit1().getId()));
        produit2 = produitRepository.findById(updatedPreparation.getProduit2().getId()).orElseThrow(() -> new RuntimeException("Produit2 not found with id " + updatedPreparation.getProduit2().getId()));

        if (produit1.getQuantiteInitiale() < updatedPreparation.getQuantite1() || produit2.getQuantiteInitiale() < updatedPreparation.getQuantite2()) {
            throw new RuntimeException("Insufficient quantity for the produits");
        }

        produit1.setQuantiteInitiale(produit1.getQuantiteInitiale() - updatedPreparation.getQuantite1());
        produit2.setQuantiteInitiale(produit2.getQuantiteInitiale() - updatedPreparation.getQuantite2());

        produitRepository.save(produit1);
        produitRepository.save(produit2);

        existingPreparation.setDesignation(updatedPreparation.getDesignation());
        existingPreparation.setDate(updatedPreparation.getDate());
        existingPreparation.setProduit1(updatedPreparation.getProduit1());
        existingPreparation.setQuantite1(updatedPreparation.getQuantite1());
        existingPreparation.setProduit2(updatedPreparation.getProduit2());
        existingPreparation.setQuantite2(updatedPreparation.getQuantite2());

        return preparationRepository.save(existingPreparation);
    }

    public void deleteById(String id) {
        Preparation preparation = preparationRepository.findById(id).orElseThrow(() -> new RuntimeException("Preparation not found with id " + id));

        // Restore original quantities
        Produit produit1 = preparation.getProduit1();
        Produit produit2 = preparation.getProduit2();
        produit1.setQuantiteInitiale(produit1.getQuantiteInitiale() + preparation.getQuantite1());
        produit2.setQuantiteInitiale(produit2.getQuantiteInitiale() + preparation.getQuantite2());

        produitRepository.save(produit1);
        produitRepository.save(produit2);

        preparationRepository.deleteById(id);
    }
}
