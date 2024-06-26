package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Produit;
import com.example.gestionlabo.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.findAll();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable String id) {
        return produitService.findById(id);
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.save(produit);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable String id, @RequestBody Produit updatedProduit) {
        Produit produit = produitService.findById(id);
        produit.setDesignation(updatedProduit.getDesignation());
        produit.setReference(updatedProduit.getReference());
        produit.setType(updatedProduit.getType());
        produit.setQuantiteInitiale(updatedProduit.getQuantiteInitiale());
        produit.setFournisseur(updatedProduit.getFournisseur());
        produit.setUniteMesure(updatedProduit.getUniteMesure());
        produit.setCategorie(updatedProduit.getCategorie());
        produit.setRubrique(updatedProduit.getRubrique());
        produit.setDateExp(updatedProduit.getDateExp());
        produit.setDurabilite((updatedProduit.getDurabilite()));
        return produitService.save(produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable String id) {
        produitService.deleteById(id);
    }
}
