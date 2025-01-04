package com.internettechnologie.pokedex.service;

import com.internettechnologie.pokedex.repository.PokemonRepository;
import com.internettechnologie.pokedex.entity.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> findAllPokemons(){
        return pokemonRepository.findAll();
    }
}
