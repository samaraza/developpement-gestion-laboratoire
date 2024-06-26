package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "preparations")
public class Preparation {
    @Id
    private String id;
    private String designation;
    private String date;
    private int quantite;

    @DBRef
    private Produit produit1;
    private int quantite1;

    @DBRef
    private Produit produit2;
    private int quantite2;
}
