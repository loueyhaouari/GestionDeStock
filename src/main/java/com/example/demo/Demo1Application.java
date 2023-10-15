package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.FamilleRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategorieServiceImpl;
import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

@Autowired
private CategorieServiceImpl categorieServiceImpl;

public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    Categorie c1=new Categorie(null,"OEUF",null);
    Categorie c2=new Categorie(null,"FRUITS",null);
    Categorie c3=new Categorie(null,"LEGUMES",null);
        categorieServiceImpl.saveCategorie(c1);
        categorieServiceImpl.saveCategorie(c2);
        categorieServiceImpl.saveCategorie(c3);
        Famille f1=new Famille();
        f1.setNom("OEUF1");
        f1.setCategorie(c1);
        f1.setSelected(true);
        f1.setAvailable(false);
        categorieServiceImpl.saveFamille(f1);

        Famille f2=new Famille();
        f2.setNom("Banane");
        f2.setCategorie(c2);
        f2.setSelected(true);
        f2.setAvailable(false);
        categorieServiceImpl.saveFamille(f2);
        Famille f3=new Famille();

        f3.setNom("Avocat");
        f3.setCategorie(c2);
        f3.setSelected(true);
        f3.setAvailable(false);
        categorieServiceImpl.saveFamille(f3);

        Famille f4=new Famille();
        f4.setNom("Manioc");
        f4.setCategorie(c3);
        f4.setSelected(true);
        f4.setAvailable(false);
        categorieServiceImpl.saveFamille(f4);

        Famille f5=new Famille();
        f5.setNom("Aubergine");
        f5.setCategorie(c3);
        f5.setSelected(true);
        f5.setAvailable(false);
        categorieServiceImpl.saveFamille(f5);

        Product p1=new Product(null,"OeufCarton1","Boite",true,false,5.5,5,"oeuf.png",null);
        Product p2=new Product(null,"OeufCarton2","Boite",true,false,8.5,5,"oeuf.png",null);
    p1.setFamille(f1);
    p2.setFamille(f1);
    categorieServiceImpl.saveProduct(p1);
    categorieServiceImpl.saveProduct(p2);


        Product p3=new Product(null,"Banane1","kg",false,false,7,5,"b1.png",null);
        Product p4=new Product(null,"Banane2","kg",false,false,7.5,5,"b1.png",null);
        p3.setFamille(f2);
        p4.setFamille(f2);
        categorieServiceImpl.saveProduct(p3);
        categorieServiceImpl.saveProduct(p4);

        Product p5=new Product(null,"Avocat1","kg",false,false,10,5,"avocat.png",null);
        Product p6=new Product(null,"Avocat2","kg",false,false,11.5,5,"avocat.png",null);
        p5.setFamille(f3);
        p6.setFamille(f3);
        categorieServiceImpl.saveProduct(p5);
        categorieServiceImpl.saveProduct(p6);

        Product p7=new Product(null,"Manioc1","kg",true,false,15,5,"manioc.png",null);
        Product p8=new Product(null,"Manioc2","kg",true,false,15,5,"manioc.png",null);
        p7.setFamille(f4);
        p8.setFamille(f4);
        categorieServiceImpl.saveProduct(p7);
        categorieServiceImpl.saveProduct(p8);
        Product p9=new Product(null,"Aubergine1","kg",false,false,20,5,"aubergine.png",null);
        Product p10=new Product(null,"Aubergine2","kg",false,false,25 ,5,"aubergine.png",null);
        p9.setFamille(f5);
        p10.setFamille(f5);
       categorieServiceImpl.saveProduct(p9);
        categorieServiceImpl.saveProduct(p10);

    }
}
