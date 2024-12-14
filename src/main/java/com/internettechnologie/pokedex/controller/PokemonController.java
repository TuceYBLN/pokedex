package com.internettechnologie.pokedex.controller;

import com.internettechnologie.pokedex.entity.Pokemon;
import com.internettechnologie.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> findAll(){
        return pokemonService.findAll();
    }
}
