package com.example.gestionlabo.service;

import com.example.gestionlabo.model.SalleTp;
import com.example.gestionlabo.repository.SalleTpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleTpService {

    @Autowired
    private SalleTpRepository salleTpRepository;

    public List<SalleTp> getAllSalleTps() {
        return salleTpRepository.findAll();
    }

    public SalleTp getSalleTpById(String id) {
        return salleTpRepository.findById(id).orElse(null);
    }

    public SalleTp createSalleTp(SalleTp salleTp) {
        return salleTpRepository.save(salleTp);
    }

    public SalleTp updateSalleTp(String id, SalleTp salleTp) {
        salleTp.setId(id);
        return salleTpRepository.save(salleTp);
    }

    public void deleteSalleTp(String id) {
        salleTpRepository.deleteById(id);
    }
}
