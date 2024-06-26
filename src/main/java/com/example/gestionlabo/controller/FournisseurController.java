package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Fournisseur;
import com.example.gestionlabo.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<Fournisseur> getAllFournisseurs() {
        return fournisseurService.findAll();
    }

    @GetMapping("/{id}")
    public Fournisseur getFournisseurById(@PathVariable String id) {
        return fournisseurService.findById(id);
    }

    @PostMapping
    public Fournisseur createFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }

    @PutMapping("/{id}")
    public Fournisseur updateFournisseur(@PathVariable String id, @RequestBody Fournisseur updatedFournisseur) {
        Fournisseur fournisseur = fournisseurService.findById(id);
        fournisseur.setNom(updatedFournisseur.getNom());
        fournisseur.setAdresse(updatedFournisseur.getAdresse());
        fournisseur.setEmail(updatedFournisseur.getEmail());
        fournisseur.setNmrTel(updatedFournisseur.getNmrTel());
        return fournisseurService.save(fournisseur);
    }

    @DeleteMapping("/{id}")
    public void deleteFournisseur(@PathVariable String id) {
        fournisseurService.deleteById(id);
    }
}
