package com.internettechnologie.pokedex.repository;

import com.internettechnologie.pokedex.entity.PokeOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeOwnerRepository extends JpaRepository<PokeOwner, Long> {
}
