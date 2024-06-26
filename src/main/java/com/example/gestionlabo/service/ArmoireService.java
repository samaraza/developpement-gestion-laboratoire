package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Armoire;
import com.example.gestionlabo.repository.ArmoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmoireService {
    @Autowired
    private ArmoireRepository armoireRepository;

    public List<Armoire> findAll() {
        return armoireRepository.findAll();
    }

    public Armoire findById(String id) {
        return armoireRepository.findById(id).orElseThrow(() -> new RuntimeException("Armoire not found with id " + id));
    }

    public Armoire save(Armoire armoire) {
        return armoireRepository.save(armoire);
    }

    public void deleteById(String id) {
        armoireRepository.deleteById(id);
    }
}
