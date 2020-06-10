package com.example.codeclan.MoreRelationships.repository;

import com.example.codeclan.MoreRelationships.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
