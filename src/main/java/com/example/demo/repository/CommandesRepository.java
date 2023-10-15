package com.example.demo.repository;

import com.example.demo.entities.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandesRepository extends JpaRepository<Commandes,String> {
}
