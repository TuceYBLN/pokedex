package com.internettechnologie.pokedex.repository;

import com.internettechnologie.pokedex.entity.PokeVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeVariantRepository extends JpaRepository<PokeVariant, Long> {

    PokeVariant findByDex(int pokeDex);
}
