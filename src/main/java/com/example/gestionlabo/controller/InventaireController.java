package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Inventaire;
import com.example.gestionlabo.service.InventaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventaires")
public class InventaireController {
    @Autowired
    private InventaireService inventaireService;

    @GetMapping
    public List<Inventaire> getAllInventaires() {
        return inventaireService.findAll();
    }

    @GetMapping("/{id}")
    public Inventaire getInventaireById(@PathVariable String id) {
        return inventaireService.findById(id);
    }

    @PostMapping
    public Inventaire createInventaire(@RequestBody Inventaire inventaire) {
        return inventaireService.save(inventaire);
    }

    @PutMapping("/{id}")
    public Inventaire updateInventaire(@PathVariable String id, @RequestBody Inventaire updatedInventaire) {
        return inventaireService.update(id, updatedInventaire);
    }

    @DeleteMapping("/{id}")
    public void deleteInventaire(@PathVariable String id) {
        inventaireService.deleteById(id);
    }
}
