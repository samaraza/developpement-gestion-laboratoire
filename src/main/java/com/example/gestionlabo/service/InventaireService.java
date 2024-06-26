package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Inventaire;
import com.example.gestionlabo.model.Produit;
import com.example.gestionlabo.repository.InventaireRepository;
import com.example.gestionlabo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventaireService {
    @Autowired
    private InventaireRepository inventaireRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Inventaire> findAll() {
        return inventaireRepository.findAll();
    }

    public Inventaire findById(String id) {
        return inventaireRepository.findById(id).orElseThrow(() -> new RuntimeException("Inventaire not found with id " + id));
    }

    public Inventaire save(Inventaire inventaire) {
        Produit produit = produitRepository.findById(inventaire.getProduit().getId())
                .orElseThrow(() -> new RuntimeException("Produit not found with id " + inventaire.getProduit().getId()));
        inventaire.setProduit(produit);
        return inventaireRepository.save(inventaire);
    }

    public Inventaire update(String id, Inventaire updatedInventaire) {
        Inventaire existingInventaire = inventaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventaire not found with id " + id));

        Produit produit = produitRepository.findById(updatedInventaire.getProduit().getId())
                .orElseThrow(() -> new RuntimeException("Produit not found with id " + updatedInventaire.getProduit().getId()));

        existingInventaire.setAnneeScolaire(updatedInventaire.getAnneeScolaire());
        existingInventaire.setCommentaire(updatedInventaire.getCommentaire());
        existingInventaire.setDate(updatedInventaire.getDate());
        existingInventaire.setResponsable(updatedInventaire.getResponsable());
        existingInventaire.setQuantiteRestante((updatedInventaire.getQuantiteRestante()));
        existingInventaire.setProduit(produit);

        return inventaireRepository.save(existingInventaire);
    }

    public void deleteById(String id) {
        inventaireRepository.deleteById(id);
    }
}
