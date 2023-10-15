package com.example.demo.service;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Commandes;
import com.example.demo.entities.Famille;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.CommandesRepository;
import com.example.demo.repository.FamilleRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService{

   private CategorieRepository categorieRepository;

    private FamilleRepository familleRepository;
    private CommandesRepository commandesRepository;
    private ProductRepository productRepository;

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Famille saveFamille(Famille famille) {
        return familleRepository.save(famille);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Categorie> getCategories() {

        return categorieRepository.findAll();
    }

    @Override
    public List<Commandes> saveCommandes(List<Commandes> commandes) {

        commandes.forEach(p->{p.setDate(new Date());});
        return  commandesRepository.saveAll(commandes);
    }

    @Override
    public List<Famille> getFamillesbyCategories(Long id) {

       Categorie categorie=categorieRepository.findById(id).orElse(null);
       List<Famille> familles=familleRepository.findFamilleByCategorie(categorie);
        return familles;
    }

    @Override
    public void deleteProduct(Long ProductId) {

    }



    @Override
    public List<Product> getProduitByfamille(Long id) {
        Famille famille=familleRepository.findById(id).orElse(null);

        List<Product> products=productRepository.findProductByFamille(famille);
        return products;
    }

    @Override
    public Product getProduitById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


}
