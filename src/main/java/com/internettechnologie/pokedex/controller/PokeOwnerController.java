package com.internettechnologie.pokedex.controller;

import com.internettechnologie.pokedex.dto.PokemonOwnerDto;
import com.internettechnologie.pokedex.service.PokeOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokeOwnerController {

    @Autowired
    private PokeOwnerService pokeOwnerService;


    @PostMapping("/owner")
    public PokemonOwnerDto save(@RequestBody PokemonOwnerDto pokemonOwnerDto) throws HttpRequestMethodNotSupportedException {
        return pokeOwnerService.save(pokemonOwnerDto);
    }
}
