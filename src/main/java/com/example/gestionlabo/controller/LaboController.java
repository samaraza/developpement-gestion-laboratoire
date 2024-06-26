package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Labo;
import com.example.gestionlabo.service.LaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/labos")
public class LaboController {

    @Autowired
    private LaboService laboService;

    @GetMapping
    public List<Labo> getAllLabos() {
        return laboService.getAllLabos();
    }

    @GetMapping("/{id}")
    public Labo getLaboById(@PathVariable String id) {
        return laboService.getLaboById(id);
    }

    @PostMapping
    public Labo createLabo(@RequestBody Labo labo) {
        return laboService.createLabo(labo);
    }

    @PutMapping("/{id}")
    public Labo updateLabo(@PathVariable String id, @RequestBody Labo labo) {
        return laboService.updateLabo(id, labo);
    }

    @DeleteMapping("/{id}")
    public void deleteLabo(@PathVariable String id) {
        laboService.deleteLabo(id);
    }
}
