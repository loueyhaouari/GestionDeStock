package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Famille implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nom;
    private boolean selected;
    private boolean available;
    @ManyToOne @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Categorie categorie;
    @OneToMany(mappedBy = "famille")
    private Collection<Product> products;


}
