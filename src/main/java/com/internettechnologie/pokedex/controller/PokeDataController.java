package com.internettechnologie.pokedex.controller;

import com.internettechnologie.pokedex.dto.PokeDataDto;
import com.internettechnologie.pokedex.service.PokeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
public class PokeDataController implements WebMvcConfigurer {

    @Autowired
    private PokeDataService pokeDataService;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://astonishing-manatee-fd2785.netlify.app/",
                        "http://localhost:3000"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    @GetMapping("/pokedata")
    public List<PokeDataDto> getData() {
        return pokeDataService.getCombinedData();
    }
}
