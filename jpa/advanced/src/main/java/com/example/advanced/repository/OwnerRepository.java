package com.example.advanced.repository;

import com.example.advanced.entity.Owner;
import com.example.advanced.entity.OwnerDTO;
import com.example.advanced.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OwnerRepository extends JpaRepository<Owner, Long>, OwnerCustomRepository {
    @Query("select new com.example.advanced.entity.OwnerDTO(o.ownerId, o.ownerName, o.ownerPhone, o.ownerAge) from Owner o where o.ownerId = :ownerId")
    public OwnerDTO findByIdToDTO(Long ownerId);
}
