package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Commande;
import com.example.gestionlabo.model.Produit;
import com.example.gestionlabo.model.ProduitCommande;
import com.example.gestionlabo.repository.CommandeRepository;
import com.example.gestionlabo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ProduitRepository produitRepository;

    public List<Commande> findAll() {

        return commandeRepository.findAll();
    }

    public Commande findById(String id) {
        return commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande not found with id " + id));
    }

    public Commande save(Commande commande) {
        // Update quantiteInitiale of each Produit in the commande
        for (ProduitCommande pc : commande.getProduits()) {
            Produit produit = produitRepository.findById(pc.getProduit().getId()).orElseThrow(() -> new RuntimeException("Produit not found with id " + pc.getProduit().getId()));
            produit.setQuantiteInitiale(produit.getQuantiteInitiale() + pc.getQuantiteAjoutee());
            produitRepository.save(produit);
        }
        return commandeRepository.save(commande);
    }

    public void deleteById(String id) {

        commandeRepository.deleteById(id);
    }

    public ByteArrayInputStream generateCommandePdf(String id) throws IOException {
        Commande commande = findById(id);
        return PdfService.generateCommandePdf(commande);
    }
}
