package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "commandes")
public class Commande {
    @Id
    private String id;
    private String designation;
    private String date;
    private String observation;
    private String numero;

    @DBRef
    private Fournisseur fournisseur;

    @DBRef
    private User user;

    private List<ProduitCommande> produits = new ArrayList<>();
}
