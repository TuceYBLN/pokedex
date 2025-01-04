package com.internettechnologie.pokedex.controller;

import com.internettechnologie.pokedex.dto.PokeDataDto;
import com.internettechnologie.pokedex.service.PokeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokeDataController {

    @Autowired
    private PokeDataService pokeDataService;

    @GetMapping("/pokedata")
    public List<PokeDataDto> getData(){
        return pokeDataService.getCombinedData();
    }
}
