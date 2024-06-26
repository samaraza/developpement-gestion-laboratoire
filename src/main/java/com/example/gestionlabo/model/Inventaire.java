package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "inventaires")
public class Inventaire {
    @Id
    private String id;
    private String anneeScolaire;
    private String commentaire;
    private String date;
    private String responsable;
    private int quantiteRestante;

    @DBRef
    private Produit produit;
}
