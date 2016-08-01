package com.gm.flowers.data.jpa.service;

import com.gm.flowers.data.jpa.domain.Memory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends PagingAndSortingRepository<Memory, String> {
}
