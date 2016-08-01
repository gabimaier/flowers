package com.gm.flowers.data.jpa.service;

import com.gm.flowers.data.jpa.domain.Species;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends PagingAndSortingRepository<Species, String> {
}
