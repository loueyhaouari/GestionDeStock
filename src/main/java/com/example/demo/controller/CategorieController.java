package com.example.demo.controller;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Commandes;
import com.example.demo.entities.Famille;
import com.example.demo.entities.Product;
import com.example.demo.service.CategorieService;
import com.example.demo.service.CategorieServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class CategorieController {

    @Autowired
    private CategorieServiceImpl categorieService;

    @GetMapping("/categories")
    public List<Categorie> categories(){
        return categorieService.getCategories();
    }
    @GetMapping("/familles/{id}")
    public List<Famille> familles(@PathVariable(name = "id") Long id){
        return categorieService.getFamillesbyCategories(id);
    }
@PostMapping("/commandes")
public List<Commandes> saveCommandes(@RequestBody List<Commandes> commandes){

        return categorieService.saveCommandes(commandes);
}
    @GetMapping("/products/{id}")
    public List<Product> products(@PathVariable(name = "id") Long id){
        return categorieService.getProduitByfamille(id);
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id){
        return categorieService.getProduitById(id);
    }

    @GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {

        Product p=categorieService.getProduitById(id);
       return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/products/"+p.getPhotoName()));
    }
}
