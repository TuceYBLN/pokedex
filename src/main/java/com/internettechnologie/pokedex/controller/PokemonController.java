package com.internettechnologie.pokedex.controller;

import com.internettechnologie.pokedex.entity.PokeVariant;
import com.internettechnologie.pokedex.entity.Pokemon;
import com.internettechnologie.pokedex.service.PokeVariantService;
import com.internettechnologie.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private PokeVariantService pokeVariantService;


    @GetMapping("/pokemons")
    public List<Pokemon> findPokemonAll(){
        return pokemonService.findAllPokemons();
    }

    @GetMapping("/pokevariants")
    public List<PokeVariant> findAll(){
        return pokeVariantService.findAllPokeVariants();
    }
}
