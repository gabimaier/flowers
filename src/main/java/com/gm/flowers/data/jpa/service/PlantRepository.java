package com.gm.flowers.data.jpa.service;

import com.gm.flowers.data.jpa.domain.Plant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends PagingAndSortingRepository<Plant, String> {
}
