package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class PreparationTP {
    @DBRef
    private Preparation preparation;
    private int quantite;
}
