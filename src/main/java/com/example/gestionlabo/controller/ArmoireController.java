package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Armoire;
import com.example.gestionlabo.service.ArmoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/armoires")
public class ArmoireController {
    @Autowired
    private ArmoireService armoireService;

    @GetMapping
    public List<Armoire> getAllArmoires() {

        return armoireService.findAll();
    }

    @GetMapping("/{id}")
    public Armoire getArmoireById(@PathVariable String id) {

        return armoireService.findById(id);
    }

    @PostMapping
    public Armoire createArmoire(@RequestBody Armoire armoire) {

        return armoireService.save(armoire);
    }

    @PutMapping("/{id}")
    public Armoire updateArmoire(@PathVariable String id, @RequestBody Armoire updatedArmoire) {
        Armoire armoire = armoireService.findById(id);
        armoire.setDesignation(updatedArmoire.getDesignation());
        armoire.setProduits(updatedArmoire.getProduits());
        return armoireService.save(armoire);
    }

    @DeleteMapping("/{id}")
    public void deleteArmoire(@PathVariable String id) {
        armoireService.deleteById(id);
    }
}
