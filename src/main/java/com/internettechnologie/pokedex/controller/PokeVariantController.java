package com.internettechnologie.pokedex.controller;

import com.internettechnologie.pokedex.dto.PokeVariantOwnedDto;
import com.internettechnologie.pokedex.entity.PokeVariant;
import com.internettechnologie.pokedex.service.PokeVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class PokeVariantController implements WebMvcConfigurer {

    @Autowired
    private PokeVariantService pokeOwnerService;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "https://astonishing-manatee-fd2785.netlify.app/",
                        "http://localhost:3000"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    @PostMapping("/owner")
    public PokeVariant save(@RequestBody PokeVariantOwnedDto id) throws HttpRequestMethodNotSupportedException {
        return pokeOwnerService.save(id);
    }
}
