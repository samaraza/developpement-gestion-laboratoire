package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class ProduitCommande {
    @DBRef
    private Produit produit;
    private int quantiteAjoutee;
}
