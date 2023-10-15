package com.example.demo.service;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Commandes;
import com.example.demo.entities.Famille;
import com.example.demo.entities.Product;

import java.util.List;

public interface CategorieService {
Categorie saveCategorie(Categorie categorie);

Famille saveFamille(Famille famille);
Product saveProduct(Product product);

    List<Categorie> getCategories();
    
    List<Commandes> saveCommandes(List<Commandes> commandes);

    List<Famille> getFamillesbyCategories(Long id) ;


    void deleteProduct(Long ProductId);

    List<Product> getProduitByfamille(Long id);

    Product getProduitById(Long id);


}
