package com.food.projeto.service;

import com.food.projeto.model.Restaurante;
import com.food.projeto.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    public Restaurante salvarRestaurante(Restaurante restaurante){return restauranteRepository.save(restaurante);}
    public List<Restaurante> buscarTodosOsRestaurante(){return restauranteRepository.findAll();}
    public Optional<Restaurante> buscarRestaurantePorId(Integer id){return restauranteRepository.findById(id);}
    public Restaurante atualizarRestaurante(Restaurante restaurante){return restauranteRepository.save(restaurante);}
    public void excluirRestaurante(Integer id){restauranteRepository.deleteById(id);}

}
