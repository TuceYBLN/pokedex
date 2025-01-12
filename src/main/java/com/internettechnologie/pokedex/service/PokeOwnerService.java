package com.internettechnologie.pokedex.service;

import com.internettechnologie.pokedex.dto.PokemonOwnerDto;
import com.internettechnologie.pokedex.entity.PokeOwner;
import com.internettechnologie.pokedex.entity.PokeVariant;
import com.internettechnologie.pokedex.repository.PokeOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;


@Service
public class PokeOwnerService {

    @Autowired
    private PokeOwnerRepository pokeOwnerRepository;

    @Autowired
    private PokeVariantService pokeVariantService;

    public PokemonOwnerDto save(PokemonOwnerDto pokemonOwnerDto) throws HttpRequestMethodNotSupportedException {
        PokeVariant pokeVariant = pokeVariantService.getById(pokemonOwnerDto.getPokeVariantId());
        if(pokeVariant.getPokeOwner() != null){
            throw new HttpRequestMethodNotSupportedException("PokeOwner wurde bereits gesetzt");
        }
        PokeOwner pokeOwner = new PokeOwner();
        pokeOwner.setPokeVariant(pokeVariant);
        pokeVariant.setPokeOwner(pokeOwner);
        pokeOwnerRepository.save(pokeOwner);

        return new PokemonOwnerDto(pokeOwner.getId(), pokeOwner.getPokeVariant().getId());
    }
}
