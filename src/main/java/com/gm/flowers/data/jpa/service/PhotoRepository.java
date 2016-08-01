package com.gm.flowers.data.jpa.service;

import com.gm.flowers.data.jpa.domain.Photo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends PagingAndSortingRepository<Photo, String> {
}
