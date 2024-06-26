package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Produit;
import com.example.gestionlabo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    public Produit findById(String id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit not found with id " + id));
    }

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteById(String id) {
        produitRepository.deleteById(id);
    }
}
