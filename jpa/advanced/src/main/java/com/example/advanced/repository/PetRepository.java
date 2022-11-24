package com.example.advanced.repository;

import com.example.advanced.entity.Pet;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long>, PetCustomRepository {
    public List<Pet> findByPetName(@Param("petName") String petName);

    @Query("select p from Pet p join fetch p.owner")
    public List<Pet> findAllFetchJoin();

    @Override
    @EntityGraph(attributePaths = "owner")
    public List<Pet> findAll();

    @EntityGraph(attributePaths = "owner")
    @Query("select p from Pet p where p.petName = :petName")
    public List<Pet> findAllWithOwner(String petName);
}
