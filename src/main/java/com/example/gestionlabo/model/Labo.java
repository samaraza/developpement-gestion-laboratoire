package com.example.gestionlabo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Data
@Document(collection = "labos")
public class Labo {

    @Id
    private String id;
    private LaboType laboType;
    @DBRef
    private List<SalleTp> salleTps;

    // Getters and Setters
}

enum LaboType {
    TECHNIQUE, SCIENTIFIQUE, INFORMATIQUE, PHYSIQUE
}
