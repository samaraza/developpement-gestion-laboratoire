package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "tps")
public class Tp {
    @Id
    private String id;
    private TpType type;
    private String jourTp;

    @DBRef
    private User prof;

    @DBRef
    private SalleTp salleTp;

    private NiveauScolaire niveauScolaire;

    private List<PreparationTP> preparations;

    private List<ProduitTP> produits;
}

