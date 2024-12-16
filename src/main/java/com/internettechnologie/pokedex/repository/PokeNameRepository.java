package com.internettechnologie.pokedex.repository;

import com.internettechnologie.pokedex.entity.PokeName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeNameRepository extends JpaRepository<PokeName, Long> {
}
