package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Fournisseur;
import com.example.gestionlabo.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {
    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur findById(String id) {
        return fournisseurRepository.findById(id).orElseThrow(() -> new RuntimeException("Fournisseur not found with id " + id));
    }

    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public void deleteById(String id) {
        fournisseurRepository.deleteById(id);
    }
}
