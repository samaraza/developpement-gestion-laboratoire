package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.SalleTp;
import com.example.gestionlabo.service.SalleTpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salleTps")
public class SalleTpController {

    @Autowired
    private SalleTpService salleTpService;

    @GetMapping
    public List<SalleTp> getAllSalleTps() {
        return salleTpService.getAllSalleTps();
    }

    @GetMapping("/{id}")
    public SalleTp getSalleTpById(@PathVariable String id) {
        return salleTpService.getSalleTpById(id);
    }

    @PostMapping
    public SalleTp createSalleTp(@RequestBody SalleTp salleTp) {
        return salleTpService.createSalleTp(salleTp);
    }

    @PutMapping("/{id}")
    public SalleTp updateSalleTp(@PathVariable String id, @RequestBody SalleTp salleTp) {
        return salleTpService.updateSalleTp(id, salleTp);
    }

    @DeleteMapping("/{id}")
    public void deleteSalleTp(@PathVariable String id) {
        salleTpService.deleteSalleTp(id);
    }
}
