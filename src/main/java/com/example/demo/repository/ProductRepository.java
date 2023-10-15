package com.example.demo.repository;

import com.example.demo.entities.Famille;
import com.example.demo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Locale;


@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductByFamille(Famille famille);
}
