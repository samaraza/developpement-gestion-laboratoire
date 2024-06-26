package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class ProduitTP {
    @DBRef
    private Produit produit;
    private int quantite;
}
