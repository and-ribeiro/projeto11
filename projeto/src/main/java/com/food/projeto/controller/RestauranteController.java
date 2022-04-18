package com.food.projeto.controller;

import com.food.projeto.model.Restaurante;
import com.food.projeto.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> salvar(@RequestBody Restaurante restaurante){
        return ResponseEntity.ok(restauranteService.salvarRestaurante(restaurante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(restauranteService.buscarRestaurantePorId(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> buscarTodos(){
        return ResponseEntity.ok(restauranteService.buscarTodosOsRestaurante());
    }

    @PutMapping
    public ResponseEntity<Restaurante> atualizar(@RequestBody Restaurante restaurante){
        ResponseEntity<Restaurante> response = null;
        if (restaurante.getId() != null && restauranteService.buscarRestaurantePorId(restaurante.getId()).isPresent()){
            response = ResponseEntity.ok(restauranteService.atualizarRestaurante(restaurante));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if(restauranteService.buscarRestaurantePorId(id).isPresent()){
            restauranteService.excluirRestaurante(id);
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

}
