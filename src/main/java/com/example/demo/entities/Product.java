package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    private String packaging;
    private boolean selected;
    private boolean available;
    private double prix;
    private int qte;
    private String photoName;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Famille famille;

}
