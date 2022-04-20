package com.food.projeto.controller;

import com.food.projeto.model.Prato;
import com.food.projeto.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pratos")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity<Prato> salvar(@RequestBody Prato prato) {
        return ResponseEntity.ok(pratoService.salvarPrato(prato));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pratoService.buscarPratoPorId(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Prato>> buscarTodos() {
        return ResponseEntity.ok(pratoService.buscarTodosOsPrato());
    }

    @PutMapping
    public ResponseEntity<Prato> atualizar(@RequestBody Prato prato) {
        ResponseEntity<Prato> response = null;
        if (prato.getId() != null && pratoService.buscarPratoPorId(prato.getId()).isPresent()) {
            response = ResponseEntity.ok(pratoService.atualizarPrato(prato));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (pratoService.buscarPratoPorId(id).isPresent()) {
            pratoService.excluirPrato(id);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;


    }
}
