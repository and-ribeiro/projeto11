package com.food.projeto.repository;


import com.food.projeto.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PratoRepository extends JpaRepository<Prato, Integer> {
}
