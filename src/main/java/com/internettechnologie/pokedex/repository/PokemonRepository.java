package com.internettechnologie.pokedex.repository;

import com.internettechnologie.pokedex.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Pokemon findByDex(int pokeDex);
}
