package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Preparation;
import com.example.gestionlabo.service.PreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preparations")
public class PreparationController {
    @Autowired
    private PreparationService preparationService;

    @GetMapping
    public List<Preparation> getAllPreparations() {
        return preparationService.findAll();
    }

    @GetMapping("/{id}")
    public Preparation getPreparationById(@PathVariable String id) {
        return preparationService.findById(id);
    }

    @PostMapping
    public Preparation createPreparation(@RequestBody Preparation preparation) {
        return preparationService.save(preparation);
    }

    @PutMapping("/{id}")
    public Preparation updatePreparation(@PathVariable String id, @RequestBody Preparation updatedPreparation) {
        return preparationService.update(id, updatedPreparation);
    }

    @DeleteMapping("/{id}")
    public void deletePreparation(@PathVariable String id) {
        preparationService.deleteById(id);
    }
}
