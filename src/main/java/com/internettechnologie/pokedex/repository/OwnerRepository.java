package com.internettechnologie.pokedex.repository;

import com.internettechnologie.pokedex.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
