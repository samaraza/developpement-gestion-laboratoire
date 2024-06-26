package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "produits")
public class Produit {
    @Id
    private String id;
    private String designation;
    private String reference;
    private ProduitType type;
    private String dateExp;
    private Categorie categorie;
    private Rubrique rubrique;
    private Durabilite durabilite;
    private int quantiteInitiale;

    @DBRef
    private Fournisseur fournisseur;

    private UniteMesure uniteMesure;
}
