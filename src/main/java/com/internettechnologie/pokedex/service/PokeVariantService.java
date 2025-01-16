package com.internettechnologie.pokedex.service;

import com.internettechnologie.pokedex.dto.PokeVariantOwnedDto;
import com.internettechnologie.pokedex.entity.PokeVariant;
import com.internettechnologie.pokedex.repository.PokeVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokeVariantService {

    @Autowired
    private PokeVariantRepository pokeVariantRepository;

    public List<PokeVariant> findAllPokeVariants(){return pokeVariantRepository.findAll();}

    public PokeVariant getById(Long id){return pokeVariantRepository.getReferenceById(id);};

    public PokeVariant save(PokeVariantOwnedDto id) {
        PokeVariant pokeVariant = getById(id.getId());
        pokeVariant.setOwned(true);
        return pokeVariantRepository.save(pokeVariant);
    }
}
