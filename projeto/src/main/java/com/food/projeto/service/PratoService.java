package com.food.projeto.service;

import com.food.projeto.model.Prato;
import com.food.projeto.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PratoService {

    @Autowired
    PratoRepository pratoRepository;

    public Prato salvarPrato(Prato prato){return pratoRepository.save(prato);}
    public List< Prato> buscarTodosOsPrato(){return pratoRepository.findAll();}
    public Optional< Prato> buscarPratoPorId(Integer id){return pratoRepository.findById(id);}
    public  Prato atualizarPrato( Prato prato){return pratoRepository.save(prato);}
    public void excluirPrato(Integer id){pratoRepository.deleteById(id);}

}
