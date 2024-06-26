package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "armoires")
public class Armoire {
    @Id
    private String id;
    private String designation;


    @DBRef
    private List<Produit> produits = new ArrayList<>();
}
