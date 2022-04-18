package com.food.projeto.util;

import com.food.projeto.model.Endereco;
import com.food.projeto.model.Prato;
import com.food.projeto.model.Restaurante;
import com.food.projeto.model.Usuario;
import com.food.projeto.repository.EnderecoRepository;
import com.food.projeto.repository.PratoRepository;
import com.food.projeto.repository.RestauranteRepository;
import com.food.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Seeding implements ApplicationRunner {

    private UsuarioRepository usuarioRepository;
    private EnderecoRepository enderecoRepository;
    private RestauranteRepository restauranteRepository;
    private PratoRepository pratoRepository;

    @Autowired
    public Seeding(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository, RestauranteRepository restauranteRepository, PratoRepository pratoRepository){
        this.enderecoRepository = enderecoRepository;
        this.usuarioRepository = usuarioRepository;
        this.restauranteRepository = restauranteRepository;
        this.pratoRepository = pratoRepository;
    }

    public void run(ApplicationArguments args){
        Usuario usuario1 = new Usuario("Anderson Ribeiro", "andersonsiilvar@gmail.com", "123456");
        usuarioRepository.save(usuario1);
        Endereco endereco1 = new Endereco("Rua Tamandaré", "997", "Liberdade", "São Paulo", "São Paulo", usuario1);
        Endereco endereco2 = new Endereco("Rua João", "123", "Pedrita", "Itaituba", "Pará", usuario1);
        enderecoRepository.save(endereco1);
        enderecoRepository.save(endereco2);

        Restaurante restaurante1 = new Restaurante("Sukiya"," Rua Joãozinho, 1060 São Paulo" ,"sukiyarestaurante@sukiya.com", "123456");
        restauranteRepository.save(restaurante1);
        Prato prato1 = new Prato("Katsu Curry", "A típica comida caseira do japão, levemente apimentado e acompanhado com nosso crocante chicken katsu (sobrecoxa empanada) e arroz japonês.", 34.90, restaurante1);
        Prato prato2 = new Prato("Bento Sukiya", "Teishoku de Tonkatsu (lombo de porco), arroz japonês, karaguê frito, gyoza.", 36.33 , restaurante1);
        pratoRepository.save(prato1);
        pratoRepository.save(prato2);
    }
}
