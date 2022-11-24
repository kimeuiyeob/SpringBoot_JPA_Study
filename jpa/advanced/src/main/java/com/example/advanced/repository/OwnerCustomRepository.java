package com.example.advanced.repository;

import com.example.advanced.entity.Owner;
import com.example.advanced.entity.OwnerDTO;
import com.example.advanced.entity.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OwnerCustomRepository {
    public Page<Owner> findAllByOwnerName(Pageable pageable);
    public List<OwnerDTO> findAllByOwnerName(String ownerName);
    public List<OwnerDTO> findAllSearch(Search search);
}
