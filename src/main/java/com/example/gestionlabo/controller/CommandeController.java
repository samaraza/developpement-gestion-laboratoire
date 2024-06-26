package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Commande;
import com.example.gestionlabo.service.CommandeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<Commande> getAllCommandes() {

        return commandeService.findAll();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable String id) {

        return commandeService.findById(id);
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {

        return commandeService.save(commande);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable String id, @RequestBody Commande updatedCommande) {
        Commande commande = commandeService.findById(id);
        commande.setDesignation(updatedCommande.getDesignation());
        commande.setDate(updatedCommande.getDate());
        commande.setObservation(updatedCommande.getObservation());
        commande.setNumero(updatedCommande.getNumero());
        commande.setFournisseur(updatedCommande.getFournisseur());
        commande.setProduits(updatedCommande.getProduits());
        commande.setUser((updatedCommande.getUser()));
        return commandeService.save(commande);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable String id) {

        commandeService.deleteById(id);
    }

    @GetMapping("/{id}/pdf")
    public void generateCommandePdf(@PathVariable String id, HttpServletResponse response) throws IOException {
        ByteArrayInputStream pdfStream = commandeService.generateCommandePdf(id);
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=commande_" + id + ".pdf");
        response.getOutputStream().write(pdfStream.readAllBytes());
    }
}
