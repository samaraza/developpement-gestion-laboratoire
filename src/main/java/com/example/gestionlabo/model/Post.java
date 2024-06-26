package com.example.gestionlabo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;
    private String title;
    private String date;
    private String content;
}
