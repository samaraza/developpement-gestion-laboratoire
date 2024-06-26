package com.example.gestionlabo.controller;

import com.example.gestionlabo.model.Tp;
import com.example.gestionlabo.service.TpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tps")
public class TpController {
    @Autowired
    private TpService tpService;

    @GetMapping
    public List<Tp> getAllTps() {
        return tpService.findAll();
    }

    @GetMapping("/{id}")
    public Tp getTpById(@PathVariable String id) {
        return tpService.findById(id);
    }

    @PostMapping
    public Tp createTp(@RequestBody Tp tp) {
        return tpService.save(tp);
    }

    @PutMapping("/{id}")
    public Tp updateTp(@PathVariable String id, @RequestBody Tp updatedTp) {
        return tpService.update(id, updatedTp);
    }

    @DeleteMapping("/{id}")
    public void deleteTp(@PathVariable String id) {
        tpService.deleteById(id);
    }
}
