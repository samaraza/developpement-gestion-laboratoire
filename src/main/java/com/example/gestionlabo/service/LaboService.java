package com.example.gestionlabo.service;

import com.example.gestionlabo.model.Labo;
import com.example.gestionlabo.repository.LaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboService {

    @Autowired
    private LaboRepository laboRepository;

    public List<Labo> getAllLabos() {
        return laboRepository.findAll();
    }

    public Labo getLaboById(String id) {
        return laboRepository.findById(id).orElse(null);
    }

    public Labo createLabo(Labo labo) {
        return laboRepository.save(labo);
    }

    public Labo updateLabo(String id, Labo labo) {
        labo.setId(id);
        return laboRepository.save(labo);
    }

    public void deleteLabo(String id) {
        laboRepository.deleteById(id);
    }
}
