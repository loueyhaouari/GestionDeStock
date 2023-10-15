package com.example.demo.repository;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
public interface FamilleRepository extends JpaRepository<Famille,Long> {
List<Famille> findFamilleByCategorie(Categorie categorie);

}
