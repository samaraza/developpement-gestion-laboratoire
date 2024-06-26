package com.example.gestionlabo.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "salleTps")
public class SalleTp {

    @Id
    private String id;
    private String numero;

    @DBRef
    private List<Armoire>armoires;



}
