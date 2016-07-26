package com.gm.flowers.data.jpa.service;

import com.gm.flowers.data.jpa.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    User findByUsername(String username);
}
