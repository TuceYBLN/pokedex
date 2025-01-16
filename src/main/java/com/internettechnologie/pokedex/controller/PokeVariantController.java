package com.internettechnologie.pokedex.controller;

import com.internettechnologie.pokedex.dto.PokeVariantOwnedDto;
import com.internettechnologie.pokedex.entity.PokeVariant;
import com.internettechnologie.pokedex.service.PokeVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PokeVariantController {

    @Autowired
    private PokeVariantService pokeOwnerService;


    @PostMapping("/owner")
    public PokeVariant save(@RequestBody PokeVariantOwnedDto id) throws HttpRequestMethodNotSupportedException {
        return pokeOwnerService.save(id);
    }
}
